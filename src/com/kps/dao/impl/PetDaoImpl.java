package com.kps.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kps.dao.PetDao;
import com.kps.entity.Pet;
import com.kps.util.DBUtil;

public class PetDaoImpl  extends  DBUtil  implements  PetDao{

	@Override
	//查询所有宠物的信息
	public List<Pet> getAllPet() {
		String sql="select * from  pet  ";
		return getPetInfosBySql(sql, null);
		
		
	}
	public   List<Pet>   getPetInfosBySql(String sql,Object...params){

		Connection  connection=null;
		PreparedStatement  preparedStatement=null;
		ResultSet    resultSet=null;
		List<Pet>  pets=new ArrayList<Pet>();
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
			   Pet   pet=new Pet();
			   pet.setId(resultSet.getInt(1));
			   pet.setName(resultSet.getString(2));
			   pet.setTypeName(resultSet.getString(3));
			   pet.setHealth(resultSet.getInt(4));
			   pet.setLove(resultSet.getInt(5));
			   pet.setBirthday(resultSet.getDate(6));
			   pet.setOwnerId(resultSet.getInt(7));
			   pet.setStoreId(resultSet.getInt(8));
			   pets.add(pet);
		
	}}catch (Exception e) {
		// TODO: handle exception
	
		   }
		finally {
			closeAll(connection, preparedStatement, resultSet);		
		}
		return  pets;

}
	@Override
	public List<Pet> updateAllPet(int id) {
		// TODO Auto-generated method stub
		String   sql="update  pet set ownerid=?";
		
		return getPetInfosBySql(sql, id);
	}}
