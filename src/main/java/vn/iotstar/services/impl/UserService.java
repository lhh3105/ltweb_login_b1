package vn.iotstar.services.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService {
	// lay toan bo ham trong tang Dao cua user
	IUserDao userDao = new UserDaoImpl();
	
	@Override
	public UserModel Login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
		return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public UserModel FindByEmail(String email) {
		
		
		return userDao.findByEmail(email);
	}

	@Override
	public boolean Insert(String email, String username, String password) {
		// TODO Auto-generated method stub
		return userDao.Insert(email, username, password);
	}

	@Override
	public boolean Update_pass(String username, String password) {
		return userDao.Update_pass(username, password);
	}

}
