package com.CloudPrinting.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class OpenFile extends ActionSupport implements SessionAware {
	String obtainedId;
	String obtainedfilename;
	Map m;
	String filedata;
	String calculatedpathoffile;
	String filenotfound;
public String getFiledata() {
		return filedata;
	}

	public void setFiledata(String filedata) {
		this.filedata = filedata;
	}


	public String getFilenotfound() {
	return filenotfound;
}

public void setFilenotfound(String filenotfound) {
	this.filenotfound = filenotfound;
}

	public String getCalculatedpathoffile() {
	return calculatedpathoffile;
}

public void setCalculatedpathoffile(String calculatedpathoffile) {
	this.calculatedpathoffile = calculatedpathoffile;
}

	public String getObtainedfilename() {
		return obtainedfilename;
	}

	public void setObtainedfilename(String obtainedfilename) {
		this.obtainedfilename = obtainedfilename;
	}

	public String getObtainedId() {
		return obtainedId;
	}

	public void setObtainedId(String obtainedId) {
		this.obtainedId = obtainedId;
	}
	public void  calulatefiledata() {
		String filedata1="";
		try
		{
			
 			File f=new File(getCalculatedpathoffile());
			FileInputStream fis=new FileInputStream(f);
			InputStreamReader isr=new InputStreamReader(fis);
			for(int i=isr.read();i!=-1;i=isr.read())
			{
				filedata1+=(char)i;
			
			}
			setFiledata(filedata1);
		}catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Override
	public String execute() throws Exception {
	System.out.println(getObtainedfilename());
			String obtainedusername = (String) m.get("username");
			String obtainedpassword = (String) m.get("password");
			setObtainedId(obtainedusername + "_" + obtainedpassword);
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session ses = sf.openSession();
			ses.beginTransaction();
			Query queryResult = ses.createQuery("from filedata where id='"
					+ getObtainedId() + "' and name='"+getObtainedfilename()+"'");
			List<filedata> Users;
			Users = (ArrayList<filedata>) queryResult.list();
		if(Users.size()==1)
		{
		for(filedata f:Users)
		{
			setCalculatedpathoffile(f.getPath());
		}
		}
		else
		{
			setFilenotfound("File not found!!!");
			return ERROR;
		}
		calulatefiledata();
			return "success";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		m = arg0;

	}
}
