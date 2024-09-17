package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String email;
	private String fullname;
	private String images;
	private String phone;
	private int roleid;
	private Date createDate;
	private String avatar;
	public UserModel() {
		super();
	}
	public UserModel(int id, String username, String password, String email, String fullname, String images,
			String phone, int roleid, Date createDate, String avatar) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.images = images;
		this.phone = phone;
		this.roleid = roleid;
		this.createDate = createDate;
		this.avatar = avatar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
	// ham khi chay nó sẽ ra chuỗi của đối tượng theo form đã định dạng trong hàm
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", fullname=" + fullname + ", images=" + images + ", phone=" + phone + ", roleid=" + roleid
				+ ", createDate=" + createDate + ", avatar=" + avatar + "]";
	}
	
	

}
