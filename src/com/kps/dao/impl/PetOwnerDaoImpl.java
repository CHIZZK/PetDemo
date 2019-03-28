package com.kps.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kps.dao.PetOwnerDao;
import com.kps.entity.Pet;
import com.kps.entity.PetOwner;
import com.kps.entity.PetStore;
import com.kps.util.DBUtil;

public class PetOwnerDaoImpl   extends DBUtil  implements  PetOwnerDao{

	@Override
	public List<PetOwner> getAllOwner() {
		// TODO Auto-generated method stub
		String  sql="select * from  petowner";
		return  getPetOwnerInfosBySql(sql, null);
		
	}
	public   List<PetOwner>   getPetOwnerInfosBySql(String sql,Object...params){

		Connection  connection=null;
		PreparedStatement  preparedStatement=null;
		ResultSet    resultSet=null;
		List<PetOwner>  petOwners=new ArrayList<PetOwner>();
		try {
			connection=DBUtil.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			if (params!=null) {
				for (int i = 0; i < params.length; i++) {
					Object object = params[i];
					preparedStatement.setObject(i+1, params[i]);
				}
			}
			resultSet=preparedStatement.executeQuery();
		   while (resultSet.next()) {
			   PetOwner   petOwner=new PetOwner();
			   petOwner.setId(resultSet.getInt(1));
			   petOwner.setName(resultSet.getString(2));
			   petOwner.setPassword(resultSet.getString(3));
			   petOwner.setMoney(resultSet.getInt(4));
			   petOwners.add(petOwner);
			   
		
	}}catch (Exception e) {
		// TODO: handle exception
	
		   }
		finally {
			closeAll(connection, preparedStatement, resultSet);		
		}
		return petOwners ;

}
	@Override
	public List<PetOwner> selectOwner(String  name,String password) {
		String sql="select *  from petowner where name=?  and password=?";
		return getPetOwnerInfosBySql(sql,name,password);
	}
	@Override
	public List<PetOwner> updateAllOwner() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
