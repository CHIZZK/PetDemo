package com.kps.service;

import com.kps.entity.Pet;
import com.kps.entity.PetOwner;

public interface PetOwnerService {
	public boolean   login(String name, String  password);
	public   void    buy(Pet pet);

}
