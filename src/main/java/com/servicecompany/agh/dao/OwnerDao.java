package com.servicecompany.agh.dao;

import com.servicecompany.agh.owner.Owner;

import java.util.Collection;

public interface OwnerDao {

    Collection<Owner> getAllOwners();

    Owner getOwnerById(int id);
}
