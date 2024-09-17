package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface IUserService {
	UserModel Login(String username, String password);
	
	UserModel FindByUserName(String username);
	
	UserModel FindByEmail(String email);
	
	boolean Insert(String email, String username, String password);
	
	boolean Update_pass(String username,String password);
	
}
