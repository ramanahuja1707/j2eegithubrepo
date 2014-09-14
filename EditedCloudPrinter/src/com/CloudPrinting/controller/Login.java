package com.CloudPrinting.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.CloudPrinting.model.RegisterInfo;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware {
	String username;
	String password;
	Map se;
	String notwithinsession = "";
	String usernotregistered = "";
	String id;
	String loginerror;

	public String getLoginerror() {
		return loginerror;
	}

	public void setLoginerror(String loginerror) {
		this.loginerror = loginerror;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsernotregistered() {
		return usernotregistered;
	}

	public void setUsernotregistered(String usernotregistered) {
		this.usernotregistered = usernotregistered;
	}

	public String getNotwithinsession() {
		return notwithinsession;
	}

	public void setNotwithinsession(String notwithinsession) {
		this.notwithinsession = notwithinsession;
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

	public String login() throws Exception {
if(validatefields().equals("false"))
{
		int j = 0;
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query queryResult = ses
				.createQuery("from RegisterInfo where username='"
						+ getUsername() + "' and password='" + getPassword()
						+ "' and userid='"+getId()+"'");
		List<RegisterInfo> Users;
		Users = (ArrayList<RegisterInfo>) queryResult.list();
		if (Users.size() == 1) {
			j = 1;
		}
		ses.getTransaction().commit();
		ses.close();
		if (j == 1) {
			se.put("username", getUsername());
			se.put("password", getPassword());
			return "registered";
		} else {
			setUsernotregistered("User Is Not Registered!!!!");
			return "notregistered";
		}
}
else
	return "error";
	}
	
	public String validatefields() {
		if(getUsername().equals(""))
		{
			setLoginerror("*Please Fill All Fields!!!");

			return "true";
		}else if(getPassword().equals(""))
		{
			setLoginerror("*Please Fill All Fields!!!");
			return  "true";
		}
		else if(getId().equals(""))
		{
			setLoginerror("*Please Fill All Fields!!!");

		return "true";	
		}else
		{
			return "false";
		}
			}
	@Override
	public void setSession(Map<String, Object> arg0) {
		se = arg0;

	}

	public String logout() {
		System.out.println("logout successfully!!!");
		se.remove("username");
		se.remove("password");
		return "logoutsuccess";

	}
}
