package com.servicecompany.agh.service;

import com.servicecompany.agh.dao.OwnerDao;
import com.servicecompany.agh.owner.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OwnerService {

    @Autowired
    @Qualifier("mysqlOwner")
    private OwnerDao ownerDao;

    public Collection<Owner> getAllOwners(){
        return this.ownerDao.getAllOwners();
    }

    public Owner getOwnerById(int id){
        return this.ownerDao.getOwnerById(id);
    }

}