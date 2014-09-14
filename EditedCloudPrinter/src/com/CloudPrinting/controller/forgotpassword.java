package com.CloudPrinting.controller;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;

import org.apache.catalina.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.CloudPrinting.model.RegisterInfo;
import com.opensymphony.xwork2.ActionSupport;

public class forgotpassword extends ActionSupport {
	private String forgotpassword;
	private String password;
	private Boolean connectivity;
	private String forgotpasswordstatus;
	private String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getForgotpasswordstatus() {
		return forgotpasswordstatus;
	}

	public void setForgotpasswordstatus(String forgotpasswordstatus) {
		this.forgotpasswordstatus = forgotpasswordstatus;
	}

	public String getForgotpassword() {
		return forgotpassword;
	}

	public void setForgotpassword(String forgotpassword) {
		this.forgotpassword = forgotpassword;
	}

	@Override
	public String execute() throws Exception {
		if(!(getForgotpassword().equals("")) && !(getUsername().equals("")))
		{
		int j = 0;
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query queryResult = ses.createQuery("from RegisterInfo where email='"
				+ getForgotpassword() + "' and username='"+getUsername()
				+"'");
		List<RegisterInfo> Users;
		Users = (ArrayList<RegisterInfo>) queryResult.list();
		if (Users.size() == 1) {
			j = 1;
		}
		ses.getTransaction().commit();
		ses.close();
		if (j == 1) {
			for (RegisterInfo r : Users) {
				password = r.getPassword();
			}
			if (mail().equals("true")) {
				return SUCCESS;
			} else {
				setForgotpasswordstatus("Internet Connection Error !!!");
				return ERROR;
			}
		} else {
			setForgotpasswordstatus("User Not Registered Yet!!!");
			return "NotRegistered";
		}
		}
		else
			setForgotpasswordstatus("Please Fill The Desired Field !!");
			return "emptyfield";
	}

	public String mail() {
		if (checkConnection()) {
			try {
				System.out.println("Collecting proerties . . .");
				// Creating the properties Object
				Properties prop = System.getProperties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.port", "587");
				prop.put("mail.smtp.starttls.enable", "true");
				prop.put("mail.smtp.auth", "true");
				// Wrapping Username and password in MuAuthenticator Object
				MyAuthenticator mauth = new MyAuthenticator(
						"ramanahuja188@gmail.com", "raman@ahuja");
				System.out.println("Establishing session.....");
				javax.mail.Session s = javax.mail.Session.getDefaultInstance(
						prop, mauth);
				// Creating the Message
				Message m = new MimeMessage(s);
				m.setRecipient(RecipientType.TO, new InternetAddress(
						getForgotpassword()));
				m.setFrom(new InternetAddress("ramanahuja188@gmail.com"));
				m.setSubject("Password Recovery Mail form Cloud Printing Softwares Delhi with Attached Your Password!!");
				// The message -- Craeting Bodypart
				BodyPart bpMessage = new MimeBodyPart();
				bpMessage
						.setText("THIS IS A PASSWORD RECOVERY MAIL FROM CLOUD PRINTING APPLICATIONS.YOUR PASSWORD IS:"
								+ password);
				// // Attachment == Creating MimeBodypart
				/*
				 * MimeBodyPart bpAttach = new MimeBodyPart();
				 * bpAttach.attachFile(new File("result.png"));
				 */

				Multipart mp = new MimeMultipart();
				mp.addBodyPart(bpMessage);
				// mp.addBodyPart(bpAttach);

				m.setContent(mp);

				// Sendnig the Mail using Transport Class
				Transport.send(m);

				System.out.println("Mail Sent Successfully ");

			} catch (MessagingException e) {
				System.out.println("Messaging Exception : " + e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Exception " + e.getMessage());
				e.printStackTrace();
			}
			return "true";
		} else {

			return "false";
		}

	}

	public Boolean checkConnection() {
		try {
			URL url = new URL("http://www.google.com/");
			URLConnection conn = url.openConnection();
			conn.connect();
			connectivity = true;
			System.out.println("Dude its Working Fine !!!");
		} catch (Exception e) {
			connectivity = false;
			System.out.println("Not Working");
		}
		return connectivity;
	}
}
