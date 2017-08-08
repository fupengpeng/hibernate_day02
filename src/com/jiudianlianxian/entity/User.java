package com.jiudianlianxian.entity;

/**
 * 
 * Title: User
 * Description: 实体类
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: hibernate_day01
 * @author fupengpeng
 * @date 2017年8月7日 上午9:07:48
 */
public class User {
	
	/*
	 * hibernate 要求实体类有一个属性唯一
	 */
	private int uid;
	private String username;
	private String password;
	private String address;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", address=" + address
				+ ", getUid()=" + getUid() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getAddress()=" + getAddress() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
