package com.kps.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kps.dao.PetStoreDao;
import com.kps.entity.PetOwner;
import com.kps.entity.PetStore;
import com.kps.util.DBUtil;

public class PetStoreDaoImpl extends  DBUtil  implements  PetStoreDao {

	@Override
	public List<PetStore> getAllStore() {
		// TODO Auto-generated method stub
		String  sql="select * from  petstore";
		return  getPetStoreInfosBySql(sql, null) ;
	}
	public   List<PetStore>   getPetStoreInfosBySql(String sql,Object...params){

		Connection  connection=null;
		PreparedStatement  preparedStatement=null;
		ResultSet    resultSet=null;
		List<PetStore>  petOwners=new ArrayList<PetStore>();
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
			   PetStore   petStore=new PetStore();
			   petStore.setId(resultSet.getInt(1));
			   petStore.setName(resultSet.getString(2));
			   petStore.setPassword(resultSet.getString(3));
			   petStore.setBalance(resultSet.getInt(4));
			   petOwners.add(petStore);
	}}catch (Exception e) {
		// TODO: handle exception
	
		   }
		finally {
			closeAll(connection, preparedStatement, resultSet);		
		}
		return petOwners ;

}
	@Override
	public List<PetStore> updatePetStore() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
