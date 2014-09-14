package com.CloudPrinting.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.CloudPrinting.model.filedata;
import com.opensymphony.xwork2.ActionSupport;

public class FileUpload extends ActionSupport implements SessionAware {
	String text;
	String s;
	String s1;
	String s2;
	Map m;
	private filedata f = new filedata();

	public filedata getF() {
		return f;
	}

	public void setF(filedata f) {
		this.f = f;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String execute() {
		try {
			String obtainedusername = (String) m.get("username");
			String obtainedpassword = (String) m.get("password");
			String obtainedname=(String)f.getName();
			File f1 = new File("F:/CloudPrint/"+obtainedname+".txt");
			FileOutputStream fo = new FileOutputStream(f1);
			PrintWriter pw = new PrintWriter(fo, true);
			pw.write(f.getData());
			pw.close();
			fo.close();
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session ses = sf.openSession();
			ses.beginTransaction();
			f.setName(obtainedname+".txt");
			f.setD(new Date());
			f.setId(obtainedusername + "_" + obtainedpassword);
			f.setPath(f1.getAbsolutePath());
			f.setStatus("uploaded");
			f.setPrintstatus("Not Printed!!");
			f.setFiletype(".txt");
			ses.save(f);
			ses.getTransaction().commit();
			ses.close();
			setS1("File created at :" + f1.getAbsolutePath());
			setS("error in file creation!!!");
			System.out.println("file created!!!");
			return SUCCESS;
		} catch (FileNotFoundException e) {
			setS(e.getMessage());
			System.out.println("file not found!!!" + e.getMessage());
			return ERROR;
		} catch (IOException e) {
			setS(e.getMessage());
			System.out.println(e.getMessage());
			return ERROR;
		}
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		m = arg0;

	}
}
