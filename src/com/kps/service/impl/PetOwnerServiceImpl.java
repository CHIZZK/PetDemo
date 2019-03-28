package com.kps.service.impl;

import com.kps.dao.PetOwnerDao;
import com.kps.dao.impl.PetOwnerDaoImpl;
import com.kps.entity.Pet;
import com.kps.entity.PetOwner;
import com.kps.service.PetOwnerService;

public class PetOwnerServiceImpl  implements  PetOwnerService {

	@Override
	public boolean login(String name, String  password) {
		// TODO Auto-generated method stub
		PetOwnerDao  petOwnerDao=new PetOwnerDaoImpl();
		if (petOwnerDao.selectOwner(name,password)!=null) {
			return true;
		}
		return  false;
	}

	@Override
	public void buy(Pet pet) {
		// TODO Auto-generated method stub
		String sql="select * from  petowner where id=?";
		String param[]= {String.valueOf(pet.getOwnerId())};
		PetOwnerDao  petOwnerDao=new PetOwnerDaoImpl();

		
		
	}


	

	
	
}
