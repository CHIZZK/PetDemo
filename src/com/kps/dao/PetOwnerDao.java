package com.kps.dao;

import java.util.List;

import com.kps.entity.PetOwner;

public interface PetOwnerDao {
	List<PetOwner>   getAllOwner();
	List<PetOwner>   selectOwner(String  name,String password);
	List<PetOwner>   updateAllOwner();//更新购买用户信息
	

}
