package com.kps.test;

import java.util.List;
import java.util.Scanner;

import com.kps.dao.PetDao;
import com.kps.dao.PetOwnerDao;
import com.kps.dao.PetStoreDao;
import com.kps.dao.impl.PetDaoImpl;
import com.kps.dao.impl.PetOwnerDaoImpl;
import com.kps.dao.impl.PetStoreDaoImpl;
import com.kps.entity.Pet;
import com.kps.entity.PetOwner;
import com.kps.entity.PetStore;
import com.kps.service.impl.PetOwnerServiceImpl;

public class Test1 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner  scanner=new  Scanner(System.in);
		startPetShop();
		ownerLogin();
		int i=scanner.nextInt();
		ownerBuy(i);
		

	}
	public static  void  startPetShop() {//在系统启动时，显示所有的宠物信息，宠物主人信息，宠物商店信息
		System.out.println("宠物商店启动");
		System.out.println("Wonderland醒来，所有宠物");
		System.out.println("*************************");
		System.out.println("序号 "+"\t"+"宠物名称");
		PetDao   petDao =new PetDaoImpl();
		List<Pet>  pets=petDao.getAllPet();
		for (Pet pet : pets) {
			System.out.println(pet.getId()+"\t"+pet.getName());
		}
		System.out.println("**************************");
		System.out.println("所有宠物的主人");
		System.out.println("**************************");
		System.out.println("序号"+"\t"+"主人姓名");
		PetOwnerDao   petOwnerDao=new PetOwnerDaoImpl();
		List<PetOwner>   petOwners=petOwnerDao.getAllOwner();
		for (PetOwner petOwner : petOwners) {
			System.out.println(petOwner.getId()+"\t"+petOwner.getName());
		}
		System.out.println("**************************");
		System.out.println("所有宠物商店");
		System.out.println("**************************");
		System.out.println("序号"+"\t"+"宠物商店名称");
		PetStoreDao   petStoreDao=new  PetStoreDaoImpl();
		List<PetStore>  petStores=petStoreDao.getAllStore();
		for (PetStore petStore : petStores) {
			System.out.println(petStore.getId()+"\t"+petStore.getName());
		}
	}
	public  static  void   ownerLogin() {
		Scanner  scanner=new  Scanner(System.in);
		PetOwnerServiceImpl   petOwnerServiceImpl=new PetOwnerServiceImpl();
		
		System.out.println("请选择输入登录模式，输入1为宠物主人登录，输入2为宠物商店登录");
		int  loginNumber=scanner.nextInt();
			if (loginNumber==1) {
			boolean flag=false;
			System.out.println("请先登录，请您输入主人的名字：");
			String  name=scanner.next();
			System.out.println("请您输入主人的密码：");
			String  password=scanner.next();
			flag=petOwnerServiceImpl.login(name, password);
			if (flag==true) {
				
				PetOwnerDao  petOwnerDao=new PetOwnerDaoImpl();
			    List<PetOwner>  petOwners=petOwnerDao.selectOwner(name, password);
			    for (PetOwner petOwner : petOwners) {
			    	 System.out.println("------恭喜您成功登录------");
			         System.out.println("------您的基本信息------");
					 System.out.println("名字："+petOwner.getName());
			         System.out.println("元宝数："+petOwner.getMoney()); 
			         System.out.println("登录成功，您可以购买和卖出宠物，如果您想购买宠物请输入1，如果想卖出宠物请输入2");
			         System.out.println("1.购买宠物");
			         System.out.println("2.卖出宠物");
			         
				}			   			
			}
			
		}else {
			System.out.println("输入有误，重新输入");
		}
		
	}
	public  static  void  ownerBuy(int i) {
	
		if (i==1) {
			System.out.println("******请输入选择要购买范围：只输入选择项的序号******");
			System.out.println("1.购买库存宠物");
			System.out.println("2.购买新培育宠物");
			Scanner  scanner=new  Scanner(System.in);
			int   m=scanner.nextInt();
			if (m==1) {
				System.out.println("******以下是库存宠物******");
				System.out.println("******请选择要购买哪个宠物，并输入选择项的序号");
				int  n=scanner.nextInt();

			}else {
								
			}
		}
	}

}
