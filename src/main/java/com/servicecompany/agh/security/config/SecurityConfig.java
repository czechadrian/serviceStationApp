package com.servicecompany.agh.security.config;

import com.servicecompany.agh.authentication.UrlAuthenticationSuccessHandler;
import com.servicecompany.agh.handlers.CustomAccessDeniedHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SimpleSavedRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        final String sqlCount = "SELECT COUNT(*) FROM USER";
        int count = jdbcTemplate.queryForObject(sqlCount, new Object[]{}, Integer.class);

        final String sqlLogin = "SELECT login FROM USER WHERE USER.id=?";
        final String sqlPassword = "SELECT password FROM USER WHERE USER.id=?";
        final String sqlRole = "SELECT role FROM USER JOIN ROLE ON USER.id_role=ROLE.id WHERE USER.id=?";

        log.info("searching users in table user");
        for (int i = 1; i <= count; i++) {

            String login = jdbcTemplate.queryForObject(sqlLogin, new Object[]{i}, String.class);
            String password = jdbcTemplate.queryForObject(sqlPassword, new Object[]{i}, String.class);
            String role = jdbcTemplate.queryForObject(sqlRole, new Object[]{i}, String.class).toUpperCase();

            auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
                    .withUser(login).password(passwordEncoder.encode(password)).roles(role);
        }


    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return new UrlAuthenticationSuccessHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                oauth2Login().and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeRequests()
//                .antMatchers("/login").permitAll()
                .antMatchers("/accountant/**").hasRole("ACCOUNTANT")
                .antMatchers("/logistician/**").hasRole("LOGISTICIAN")
                .antMatchers("/manager/**").hasRole("MANAGER")
                .antMatchers("/mechanic/**").hasRole("MECHANIC")
                .antMatchers("/**").hasAnyRole("ACCOUNTANT", "LOGISTICIAN", "MANAGER", "MECHANIC")
                .anyRequest().authenticated()
//.and().formLogin().loginProcessingUrl("/login").successHandler(myAuthenticationSuccessHandler())
//                .and().logout().logoutSuccessUrl("/login").permitAll()
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler());
    }

    @Bean
    public RequestCache refererRequestCache() {
        return new HttpSessionRequestCache() {
            @Override
            public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
                String referrer = request.getHeader("referer");
                if (referrer != null) {
                    request.getSession().setAttribute("SPRING_SECURITY_SAVED_REQUEST", new SimpleSavedRequest(referrer));
                }
            }
        };
    }

}
