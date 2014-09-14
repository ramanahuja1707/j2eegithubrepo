package com.cyber.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.opensymphony.xwork2.ActionSupport;
@Entity
public class Client extends ActionSupport{
	@Id
	String clientid;
	String name;
	String username;
	int age;
	String gender;
	String email;
	String password;
	String confirmpassword;
	@Temporal(TemporalType.DATE)
	Date d;
// Post p=new Post();
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	
/*public Post getP() {
		return p;
	}
	public void setP(Post p) {
		this.p = p;
	}*/
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
}

