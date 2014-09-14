package com.CloudPrinting.controller;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.CloudPrinting.model.filedata;
import com.opensymphony.xwork2.ActionSupport;

public class printimagefiles extends ActionSupport implements SessionAware{
	String ObtainedId;
	Map m;
	String filetype;
	String calculatedpath;
	public String getCalculatedpath() {
		return calculatedpath;
	}
	public void setCalculatedpath(String calculatedpath) {
		this.calculatedpath = calculatedpath;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	String obtainedfilename;
	
	public String getObtainedfilename() {
		return obtainedfilename;
	}
	public void setObtainedfilename(String obtainedfilename) {
		this.obtainedfilename = obtainedfilename;
	}
	public String getObtainedId() {
		return ObtainedId;
	}
	public void setObtainedId(String obtainedId) {
		ObtainedId = obtainedId;
	}
	private Boolean pngprinting() throws PrintException, IOException {
		String obtainedusername = (String) m.get("username");
		String obtainedpassword = (String) m.get("password");
		setObtainedId(obtainedusername + "_" + obtainedpassword);
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query queryResult = ses.createQuery("from filedata where id='"
				+ getObtainedId() + "' and name='"+getObtainedfilename()+"'");
		List<filedata> Users = (ArrayList<filedata>) queryResult.list();
	if(Users.size()==1)
	for(filedata f:Users)
	{
		setCalculatedpath(f.getPath());
	}
	if(!(getCalculatedpath().equals("")))
			{
		 PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		    pras.add(new Copies(1));
		    PrintService pss[] = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.GIF, pras);
		    if (pss.length == 0)
		      throw new RuntimeException("No printer services available.");
		    PrintService ps = pss[3];
		    System.out.println("Printing to " + ps);
		    DocPrintJob job = ps.createPrintJob();
		    FileInputStream fin = new FileInputStream(getCalculatedpath());
		    Doc doc = new SimpleDoc(fin, DocFlavor.INPUT_STREAM.GIF, null);
		    job.print(doc, pras);
		    fin.close();
		    return true;
			}
	else
		return false;
	}
	@Override
	public String execute() throws Exception {
		if(pngprinting())
		{
		return SUCCESS;
		}
		else
			return ERROR;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		m=arg0;
		
	}
	
}
