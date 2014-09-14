package com.cyber.in;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cyber.model.Client;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware {
	String username;
	String password;
	String id;
	private Map m;
	String loginerror;
	String logoutstatus;

	public String getLogoutstatus() {
		return logoutstatus;
	}

	public void setLogoutstatus(String logoutstatus) {
		this.logoutstatus = logoutstatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginerror() {
		return loginerror;
	}

	public void setLoginerror(String loginerror) {
		this.loginerror = loginerror;
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

	public String execute() {
		String s = login();
		return s;
	}

	public String login() {
		if(validatefields().equals("false"))
		{
		int j = 0;
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query queryResult = ses.createQuery("from Client where username='"
				+ getUsername() + "' and password='" + getPassword()
				+ "' and clientid='" + getId() + "'");
		List<Client> Users;
		Users = (ArrayList<Client>) queryResult.list();
		if (Users.size() == 1) {
			j = 1;
		}
		ses.getTransaction().commit();
		ses.close();
		if (j == 1) {
			m.put("username", getUsername());
			m.put("password", getPassword());
			return SUCCESS;
		} else
			setLoginerror("*User Not Registered!!!");
		return ERROR;
		}else
		{
		return ERROR;
		}
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

	public String logout() {
		if (m.containsKey("username") && m.containsKey("password")) {
			m.remove("username");
			m.remove("password");
			setLogoutstatus("Logout Successfully!!!");
			return "success";
		} else
			setLogoutstatus("Logout Failure!!!");
			return "error";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		m = arg0;
	}

}
