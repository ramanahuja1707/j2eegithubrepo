package com.CloudPrinting.controller;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.awt.geom.Point2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
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

import com.CloudPrinting.model.RegisterInfo;
import com.CloudPrinting.model.filedata;
import com.opensymphony.xwork2.ActionSupport;

public class printpage extends ActionSupport implements SessionAware,Printable
{
	String filedata;
	String printstatus;
	String obtainedId;
	String obtainedfilename;
	Map m;
	String calculatedpathoffile;
	String filenotfound;
	  static AttributedString myStyledText = null;
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

	public String getPrintstatus() {
		return printstatus;
	}

	public void setPrintstatus(String printstatus) {
		this.printstatus = printstatus;
	}

	public String getFiledata() {
		return filedata;
	}

	public void setFiledata(String filedata) {
		this.filedata = filedata;
	}
public void callforprint() throws Exception
{
	/**Location of a file to print**/
    String fileName = "F:/hello.txt";
    /**Read the text content from this location **/
    String mText = getFiledata();
    /**Create an AttributedString object from the text read*/
    myStyledText = new AttributedString(mText);
   execute();
}
	@Override
	public String execute() throws Exception {
		if (exe().equals("success")) {
			  String fileName = getCalculatedpathoffile();
			String mText = getFiledata();
			 myStyledText = new AttributedString(mText);
			PrinterJob printerJob = PrinterJob.getPrinterJob();
		      Book book = new Book();
		        book.append(new printpage(), new PageFormat());
		        printerJob.setPageable(book);
		        boolean doPrint = printerJob.printDialog();
		        if (doPrint) {
		            try {
		            	setPrintstatusafterprintjob();
		                printerJob.print();
		                setPrintstatus("printed!!");
						return SUCCESS;
		            } catch (PrinterException ex) {
		            	setPrintstatus("unable to print!!!");
						System.out.println("printer exception!!!" + ex.getMessage());
						return ERROR;
		            }
		        }
			return "printfailure";
		} else
			return ERROR;
	}

	public void calulatefiledata() {
		String filedata1 = "";
		try {
			File f = new File(getCalculatedpathoffile());
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(isr);
			int j = 0;
			String line;
			while((line=br.readLine())!=null)
			{
				filedata1+=line+"\n";
			}
			setFiledata(filedata1);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
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
		calulatefiledata();
		return "success";
	}

	void setPrintstatusafterprintjob() {
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
				f.setPrintstatus("Printed");
				ses.update(f);
			}
		} else {
			setFilenotfound("File not found!!!");
		}
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		m = arg0;

	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		if(pageIndex>0)
		{
			return NO_SUCH_PAGE;
		}
		   Graphics2D graphics2d = (Graphics2D) graphics;
	       /**
	        * Move the origin from the corner of the Paper to the corner of the imageable
	        * area.
	        */
	       graphics2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

	       /** Setting the text color**/
	       graphics2d.setPaint(Color.black);
	       /**
	        * Use a LineBreakMeasurer instance to break our text into lines that fit the
	        * imageable area of the page.
	        */
	       Point2D.Float pen = new Point2D.Float();
	       AttributedCharacterIterator charIterator = myStyledText.getIterator();
	       LineBreakMeasurer measurer = new LineBreakMeasurer(charIterator,
	               graphics2d.getFontRenderContext());
	       float wrappingWidth = (float) pageFormat.getImageableWidth();
	       while (measurer.getPosition() < charIterator.getEndIndex()) {
	           TextLayout layout = measurer.nextLayout(wrappingWidth);
	           pen.y += layout.getAscent();
	           float dx = layout.isLeftToRight() ? 0 : (wrappingWidth - layout
	                   .getAdvance());
	           layout.draw(graphics2d, pen.x + dx, pen.y);
	           pen.y += layout.getDescent() + layout.getLeading();
	       }
	/*	Graphics2D g2d=(Graphics2D)graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	String[] s=new String[10];
	s=getFiledata().split("\n");
		graphics.drawString(s[0], 100, 100);*/
			return PAGE_EXISTS;
		}
	}

