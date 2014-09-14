package com.CloudPrinting.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.CloudPrinting.model.filedata;
import com.opensymphony.xwork2.ActionSupport;

public class uploadpdf extends ActionSupport implements
		ServletRequestAware, SessionAware {
	filedata f = new filedata();
	String samefilename;
	String fileuploadstatus;
	public String getFileuploadstatus() {
		return fileuploadstatus;
	}

	public void setFileuploadstatus(String fileuploadstatus) {
		this.fileuploadstatus = fileuploadstatus;
	}

	public String getSamefilename() {
		return samefilename;
	}

	public void setSamefilename(String samefilename) {
		this.samefilename = samefilename;
	}

	File userImage;
	String userImageContentType;
	String userImageFileName;
	Map m;
	HttpServletRequest request;

	public filedata getF() {
		return f;
	}

	public void setF(filedata f) {
		this.f = f;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		m = arg0;

	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;

	}

	public boolean checkexistingfilename() {
		String obtainedusername=(String)m.get("username");
		String obtainedpassword=(String)m.get("password");
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query queryResult = ses
				.createQuery("from filedata where id='"
						+ obtainedusername +"_"+obtainedpassword+ "'and name='"+getUserImageFileName()+"'");
		List<filedata> Users;
		Users = (ArrayList<filedata>) queryResult.list();
		if(Users.size()==1)
		return true;
		else
			return false;
	}

	@Override
	public String execute() throws Exception {
		if(userImage!=null)
		{
		if(!(checkexistingfilename()))
		{
		try {
			String filePath = request.getServletContext().getRealPath("/");
			System.out.println("Server  Path : " + filePath);
			File fileToCreate = new File(filePath, userImageFileName);
			// File permStorage = new File("/home/guffy/", userImageFileName);
			FileUtils.copyFile(userImage, fileToCreate);
			// FileUtils.copyFile(userImage, permStorage);
			// String filepath = fileToCreate.getAbsolutePath();
			System.out.println("Created File Path : "
					+ fileToCreate.getAbsolutePath());
			System.out.println("File  Selected : "
					+ userImage.getAbsolutePath());
			String obtainedusername = (String) m.get("username");
			String obtainedpassword = (String) m.get("password");
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session ses = sf.openSession();
			ses.beginTransaction();
			f.setPath(fileToCreate.getAbsolutePath());
			f.setD(new Date());
			f.setId(obtainedusername + "_" + obtainedpassword);
			f.setStatus("uploaded");
			f.setPrintstatus("Not Printed!!");
			f.setFiletype("pdf");
			f.setName(userImageFileName);
			f.setData("pdf file data!!!");
			ses.save(f);
			ses.getTransaction().commit();
			ses.close();
			setFileuploadstatus("File Uploaded Successfully!!!!");
			return SUCCESS;
		} catch (IOException e) {
			System.out.println("IO Exception " + e.getMessage());
			e.printStackTrace();
			return INPUT;
		}
		}else
			setSamefilename("File of same name already exists!!!");
			return "filexistingofsamename";
	}
		else
		{
			setSamefilename("Please Attach a File !!!!");
			return "filemissing";
		}
	}
}
