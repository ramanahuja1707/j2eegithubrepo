package com.CloudPrinting.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.CloudPrinting.model.RegisterInfo;
import com.CloudPrinting.model.filedata;
import com.opensymphony.xwork2.ActionSupport;

public class ShowFiles extends ActionSupport implements SessionAware{

	private filedata d=new filedata();
Map m;
String notreceivingdata="";


List<filedata> receiveddata=new ArrayList<filedata>();
public String getNotreceivingdata() {
	return notreceivingdata;
}

public void setNotreceivingdata(String notreceivingdata) {
	this.notreceivingdata = notreceivingdata;
}
	public List<filedata> getReceiveddata() {
	return receiveddata;
}

public void setReceiveddata(List<filedata> receiveddata) {
	this.receiveddata = receiveddata;
}

	public filedata getD() {
		return d;
	}

	public void setD(filedata d) {
		this.d = d;
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
						+ obtainedusername +"_"+obtainedpassword+ "' and filetype='"+".txt"+"'");
		List<filedata> Users;
		Users = (ArrayList<filedata>) queryResult.list();
		if(Users.size()==0)
			return "nodatafound";
		setReceiveddata((List<filedata>)Users);
		setNotreceivingdata("file list error!!!!");
		return "success";
		}else
			return ERROR;
			}

	@Override
	public void setSession(Map<String, Object> arg0) {
		m=arg0;
		
	}
	String showimagefiles()
	{
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
						+ obtainedusername +"_"+obtainedpassword+ "'and filetype='"+"image"+"'");
		List<filedata> Users;
		Users = (ArrayList<filedata>) queryResult.list();
		if(Users.size()==0)
			return "nodatafound";
		setReceiveddata((List<filedata>)Users);
		setNotreceivingdata("file list error!!!!");
		return "success";
		}else
			return ERROR;
	}
}
