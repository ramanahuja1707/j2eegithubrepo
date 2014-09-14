package com.CloudPrinting.controller;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.CloudPrinting.model.filedata;
import com.gnostice.pdfone.PDFOne;
import com.gnostice.pdfone.PdfDocument;
import com.gnostice.pdfone.PdfException;
import com.gnostice.pdfone.PdfPrinter;
import com.opensymphony.xwork2.ActionSupport;

public class pdfprint extends ActionSupport implements SessionAware {
	String filedata;
	String printstatus;
	String calculatedpathoffile;
	String filenotfound;
	String obtainedId;
	String obtainedfilename;

	public String getObtainedId() {
		return obtainedId;
	}

	public void setObtainedId(String obtainedId) {
		this.obtainedId = obtainedId;
	}

	public String getObtainedfilename() {
		return obtainedfilename;
	}

	public void setObtainedfilename(String obtainedfilename) {
		this.obtainedfilename = obtainedfilename;
	}

	public String getFiledata() {
		return filedata;
	}

	public void setFiledata(String filedata) {
		this.filedata = filedata;
	}

	public String getCalculatedpathoffile() {
		return calculatedpathoffile;
	}

	public void setCalculatedpathoffile(String calculatedpathoffile) {
		this.calculatedpathoffile = calculatedpathoffile;
	}

	public String getFilenotfound() {
		return filenotfound;
	}

	public void setFilenotfound(String filenotfound) {
		this.filenotfound = filenotfound;
	}

	Map m;
	static {
		PDFOne.activate("T95VZE:W8HBPVA:74VQ8QV:LO4V8",
				"9B1HRZAP:X5853ERNE:5EREMEGRQ:TX1R10");
	}

	@Override
	public String execute() throws Exception {

		if (exe().equals("success")) {
			PdfDocument d = new PdfDocument();
			d.load(getCalculatedpathoffile());
			PdfPrinter printer = new PdfPrinter();
			printer.setDocument(d);
			printer.showPrintDialog();
			d.close();
					return SUCCESS;
				}else
					return ERROR;
				}

	@Override
	public void setSession(Map<String, Object> arg0) {
		m = arg0;
	}
	public String exe() throws Exception {
		System.out.println(getObtainedfilename());
		String obtainedusername = (String) m.get("username");
		String obtainedpassword = (String) m.get("password");
		setObtainedId(obtainedusername + "_" + obtainedpassword);
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query queryResult = ses.createQuery("from filedata where id='"
				+ getObtainedId() + "' and name='" + getObtainedfilename()
				+ "'");
		List<filedata> Users;
		Users = (ArrayList<filedata>) queryResult.list();
		if (Users.size() == 1) {
			for (filedata f : Users) {
				setCalculatedpathoffile(f.getPath());
			}
		} else {
			setFilenotfound("File not found!!!");
			return ERROR;
		}
		return "success";
	}
}
