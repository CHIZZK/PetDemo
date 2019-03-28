package com.kps.dao;

import java.util.List;

import com.kps.entity.PetStore;

public interface PetStoreDao {
	List<PetStore>   getAllStore();//获取所有商店信息
	List<PetStore>   updatePetStore();//更新商店信息

}
