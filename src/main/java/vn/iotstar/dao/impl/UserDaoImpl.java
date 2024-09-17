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
	public boolean Insert(String email, String username, String password) {
		// TODO Auto-generated method stub
		boolean isthem = false;
		String sql = "INSERT INTO users(email, username, password,roleid) VALUES (?,?,?,1)";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, username);
			ps.setString(3, password);
			
			int rowsInserted = ps.executeUpdate();
			if (rowsInserted>0) {
				isthem = true;
			} 

		} catch (Exception e) {e.printStackTrace(); }
		
		
		
		
		return isthem;
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
	
	@Override
	public UserModel findByEmail(String email) {
		String sql = "SELECT * FROM users WHERE email = ?";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
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
	
	@Override
	public boolean Update_pass(String username, String password) {
		boolean isupdate = false;
		String sql = "UPDATE users SET password =  ? WHERE username =  ?";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, username);
			
			int rowsUpdated = ps.executeUpdate();

	            // Kiểm tra kết quả
	        if (rowsUpdated > 0) {
	                isupdate = true;
	            }
	            
		} catch (Exception e) {e.printStackTrace(); }
		
		
		return isupdate;
		
	}

	
	public static void main(String[] args) {
		UserDaoImpl x = new UserDaoImpl();
		System.out.println(x.Update_pass("huy","111"));
	}

	
	

	

}
