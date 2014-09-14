package com.CloudPrinting.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.CloudPrinting.model.RegisterInfo;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.Execute;

public class Registration extends ActionSupport {
	String RegistrationSuccess = "";
	String usernamealreadyexists = "";
	private RegisterInfo r = new RegisterInfo();
	Boolean connectivity;

	public Boolean getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(Boolean connectivity) {
		this.connectivity = connectivity;
	}

	public RegisterInfo getR() {
		return r;
	}

	public void setR(RegisterInfo r) {
		this.r = r;
	}
	public String getRegistrationSuccess() {
		return RegistrationSuccess;
	}

	public void setRegistrationSuccess(String registrationSuccess) {
		RegistrationSuccess = registrationSuccess;
	}
	public String getUsernamealreadyexists() {
		return usernamealreadyexists;
	}

	public void setUsernamealreadyexists(String usernamealreadyexists) {
		this.usernamealreadyexists = usernamealreadyexists;
	}

	public String execute() {

		String returnedcheck = check();
		if (returnedcheck.equals("false")) {
			if(mail().equals("true"))
			{
				r.setD(new Date());
				r.setUserid(r.getUsername() + "_" + r.getPassword());
				SessionFactory sf = new Configuration().configure()
						.buildSessionFactory();
				Session ses = sf.openSession();
				ses.beginTransaction();
				ses.save(r);
				ses.getTransaction().commit();
				ses.close();
				System.out.println("inside excute!!!");
				setRegistrationSuccess("Registration Successful!!!");
				return SUCCESS;
			}else
			{
				setRegistrationSuccess("Either internet connection error or Invalid mail !!!");
				return "checkInternetOrMail";
			}
		} else {
			return "useralreadyexists";
		}

	}

	public String check() {
		int j = 0;
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query queryResult = ses
				.createQuery("from RegisterInfo where username='"
						+ r.getUsername() + "'");
		List<RegisterInfo> Users;
		Users = (ArrayList<RegisterInfo>) queryResult.list();
		if (Users.size() == 1) {
			j = 1;
		}
		ses.getTransaction().commit();
		ses.close();
		if (j == 1) {
			setUsernamealreadyexists("Username Already Exists!!!");
			return "true";
		} else
			return "false";
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

				// Setting the Recipents
				// m.setRecipient(RecipientType.TO, new InternetAddress(
				// "ramanahuja188@gmail.com"));

				m.setRecipient(RecipientType.TO,
						new InternetAddress(r.getEmail()));

				// m.setRecipient(RecipientType.TO, new InternetAddress(
				// "ramanahuja188@gmail.com"));

				// setting the headers
				m.setFrom(new InternetAddress("ramanahuja188@gmail.com"));

				m.setSubject("Welcome Mail form Cloud Printing Softwares Delhi with Attached Your User-Id!!");

				// The message -- Craeting Bodypart
				BodyPart bpMessage = new MimeBodyPart();
				bpMessage
						.setText("THIS IS A WELCOME MAIL FROM CLOUD PRINTING APPLICATIONS.YOUR LOGIN USER-ID IS:"
								+ r.getUsername() + "_" + r.getPassword());

				// // Attachment == Creating MimeBodypart
			/*	MimeBodyPart bpAttach = new MimeBodyPart();
				bpAttach.attachFile(new File("result.png"));*/

				Multipart mp = new MimeMultipart();
				mp.addBodyPart(bpMessage);
			//	mp.addBodyPart(bpAttach);

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
			System.out.println("Dude its Working Fine ! ");
		} catch (Exception e) {
			connectivity = false;
			System.out.println("Not Working");
		}
		return connectivity;
	}
}
