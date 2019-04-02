package com.servicecompany.agh.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JdbcTemplate jdbcTemplate;





    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        final String sqlCount = "SELECT COUNT(*) FROM USER";
        int count = jdbcTemplate.queryForObject(sqlCount, new Object[] {}, Integer.class);

        final String sqlLogin = "SELECT login FROM USER WHERE USER.id=?";
        final String sqlPassword = "SELECT password FROM USER WHERE USER.id=?";
        final String sqlRole = "SELECT role FROM USER JOIN ROLE ON USER.id_role=ROLE.id WHERE USER.id=?";

        for( int i=1; i <= count; i++ ) {

            String login = jdbcTemplate.queryForObject(sqlLogin, new Object[] {i}, String.class);
            String password = jdbcTemplate.queryForObject(sqlPassword, new Object[] {i}, String.class);
            String role = jdbcTemplate.queryForObject(sqlRole, new Object[] {i}, String.class).toUpperCase();

            auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
                    .withUser(login).password(passwordEncoder.encode(password)).roles(role);
        }
        /*
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)

                .withUser("manager").password(passwordEncoder.encode("password")).roles("MANAGER")
                .and()
                .withUser("mechanic").password(passwordEncoder.encode("password")).roles("MECHANIC");
                */

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/accountant/**").hasRole("ACCOUNTANT")
                .antMatchers("/logistician/**").hasRole("LOGISTICIAN")
                .antMatchers("/manager/**").hasRole("MANAGER")
                .antMatchers("/mechanic/**").hasRole("MECHANIC")
                .antMatchers("/**").hasAnyRole("ACCOUNTANT", "LOGISTICIAN","MANAGER","MECHANIC")
                .and().formLogin()
                .and().logout().logoutSuccessUrl("/login").permitAll()
                .and().csrf().disable();
    }


}
