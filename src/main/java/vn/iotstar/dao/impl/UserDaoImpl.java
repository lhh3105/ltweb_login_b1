package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectMySQL;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao{
	
	
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<UserModel> findAll() {
		String sql = "select * from users";
		List<UserModel> list = new ArrayList<>();
		
		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				list.add(
						new UserModel(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getString("fullname"),
						rs.getString("images"),
						rs.getString("phone"),
						rs.getInt("roleid"),
						rs.getDate("createDate"),
						rs.getString("avatar")
						)
					);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Insert(UserModel user) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				return user; 
				}
		} catch (Exception e) {e.printStackTrace(); }
		return null;

	}
	
	
	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		List<UserModel> list  = userDao.findAll();
		System.out.println(userDao.findByUserName("hoang"));
	}

	

}
