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
import com.cyber.model.Post;
import com.opensymphony.xwork2.ActionSupport;

public class profile extends ActionSupport implements SessionAware{
	List<Client> obtainedprofile=new ArrayList<Client>();
	public List<Client> getObtainedprofile() {
		return obtainedprofile;
	}

	public void setObtainedprofile(List<Client> obtainedprofile) {
		this.obtainedprofile = obtainedprofile;
	}

	Map m;
@Override
public String execute() throws Exception {
	String obtainedusername=(String)m.get("username");
	String obtainedpassword=(String)m.get("password");
	SessionFactory sf = new Configuration().configure()
			.buildSessionFactory();
	Session ses = sf.openSession();
	ses.beginTransaction();
	Query q = ses.createQuery("from Client where username='"
			+ obtainedusername + "' and password='"+obtainedpassword+"'");
	List<Client> obtained = (ArrayList<Client>) q.list();
	setObtainedprofile(obtained);
	if (obtained.size() == 1)
		return "posttoprofilesuccess";
	else
		return "posttonodata";
}

@Override
public void setSession(Map<String, Object> arg0) {
m=arg0;
}
}
