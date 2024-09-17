package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	boolean Insert(String email, String username, String password);
	
	UserModel findByUserName(String username);
	
	UserModel findByEmail(String email);
	
	boolean Update_pass(String email,String password);

}
