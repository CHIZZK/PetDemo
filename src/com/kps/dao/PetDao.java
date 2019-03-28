package com.kps.dao;

import java.util.List;

import com.kps.entity.Pet;

public interface PetDao {
	List<Pet> getAllPet();
	List<Pet> updateAllPet(int id);//更新宠物信息

}
