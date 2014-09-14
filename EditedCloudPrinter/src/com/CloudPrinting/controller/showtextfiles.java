package com.CloudPrinting.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.CloudPrinting.model.filedata;
import com.opensymphony.xwork2.ActionSupport;

public class showtextfiles extends ActionSupport implements SessionAware{
Map m;
private filedata d=new filedata();
List<filedata> receiveddata=new ArrayList<filedata>();
	public filedata getD() {
	return d;
}
public void setD(filedata d) {
	this.d = d;
}
public List<filedata> getReceiveddata() {
	return receiveddata;
}
public void setReceiveddata(List<filedata> receiveddata) {
	this.receiveddata = receiveddata;
}
	@Override
	public void setSession(Map<String, Object> arg0) {
		m=arg0;
	}
@Override
	public String execute() throws Exception {
	if(m.get("username")!=null && m.get("password")!=null)
	{
	String obtainedusername=(String)m.get("username");
	String obtainedpassword=(String)m.get("password");
	SessionFactory sf = new Configuration().configure()
			.buildSessionFactory();
	Session ses = sf.openSession();
	ses.beginTransaction();
	Query queryResult = ses
			.createQuery("from filedata where id='"
					+ obtainedusername +"_"+obtainedpassword+ "'and filetype='"+"text"+"'");
	List<filedata> Users;
	Users = (ArrayList<filedata>) queryResult.list();
	if(Users.size()==0)
		return "nodatafound";
	setReceiveddata((List<filedata>)Users);
	return "success";
	}else
		return ERROR;
	}
}
