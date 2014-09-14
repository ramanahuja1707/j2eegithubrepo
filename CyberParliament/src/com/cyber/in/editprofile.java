package com.cyber.in;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cyber.model.Client;
import com.opensymphony.xwork2.ActionSupport;

public class editprofile extends ActionSupport implements SessionAware {
	Map m;
	String editstatus;
String password;
	public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

	public String getEditstatus() {
		return editstatus;
	}

	public void setEditstatus(String editstatus) {
		this.editstatus = editstatus;
	}

	Client c = new Client();

	public Client getC() {
		return c;
	}

	public void setC(Client c) {
		this.c = c;
	}

	@Override
	public String execute() throws Exception {
		if (c != null) {
			setEmailAndGender();
			c.setClientid(c.getUsername() + "_" + c.getPassword());
			c.setPassword(getPassword());
			c.setConfirmpassword(getPassword());
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session ses = sf.openSession();
			ses.beginTransaction();
			ses.update(c);
			ses.getTransaction().commit();
			ses.close();
			setEditstatus("Profile Successfully updated !!!");
			return "editprofilesuccess";
		} else {
			return "editprofilefailure";
		}
	}

	void setEmailAndGender() {
		String username = (String) m.get("username");
		String password = (String) m.get("password");
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query queryResult = ses.createQuery("from Client where username='"
				+ username + "' and password='" + password + "'");
		List<Client> Users;
		Users = (ArrayList<Client>) queryResult.list();
		if (Users.size() == 1) {
		c.setEmail(Users.get(0).getEmail());
		c.setGender(Users.get(0).getGender());
		c.setD(Users.get(0).getD());
		c.setAge(Users.get(0).getAge());
		}
		ses.getTransaction().commit();
		ses.close();
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		m = arg0;
	}
}
