package com.cyber.in;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import com.cyber.in.MyAuthenticator;
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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cyber.model.Client;
import com.cyber.model.Post;
import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {
	private Client c = new Client();
	String registrationsuccess;
	public String getRegistrationsuccess() {
		return registrationsuccess;
	}

	public void setRegistrationsuccess(String registrationsuccess) {
		this.registrationsuccess = registrationsuccess;
	}

	public Client getC() {
		return c;
	}

	public void setC(Client c) {
		this.c = c;
	}
	public void validate() {
		setRegistrationsuccess("*Fill All Fields!!!");
		System.out.println("inside validator!!!!");
		if (c.getUsername().equals("")) {
			addFieldError("username", "Please enter username!!");
		}
		if (c.getPassword().equals("")) {
			addFieldError("password", "Please enter password!!");
		}
		if (c.getName().equals("")) {
			addFieldError("name", "Please enter name!!");
		}
		if (c.getAge() == 0) {
			addFieldError("age", "Please enter age!!");
		}
		if (c.getEmail().equals("")) {
			addFieldError("email", "Please enter email!!");
		}
		if (c.getConfirmpassword().equals("")) {
			addFieldError("confirmpassword", "Please enter confirm password!!");
		}
	}

	public String execute() {
		String checkuserstatus=check();
		if(!(checkuserstatus.equals("true")))
		{
		String mailstatus=mail();
		if(mailstatus.equals("success"))
		{
		if (c != null) {
			c.setD(new Date());
			c.setClientid(c.getUsername() + "_" + c.getPassword());
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session ses = sf.openSession();
			ses.beginTransaction();
			ses.save(c);
			ses.getTransaction().commit();
			ses.close();
			System.out.println("inside excute!!!");
           setRegistrationsuccess("Registration Successful!!!");
			return SUCCESS;
		} else
			setRegistrationsuccess("Error in Registration!!!");
			return ERROR;
		}
		else
		{
			setRegistrationsuccess("E-mail Error...Invalid Email-Id!!!");
			return ERROR;	
		}
		}else
		{
			setRegistrationsuccess("User Already Registered!!!");
			return ERROR;
		}
		
	}
	public String mail()
	{
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

			javax.mail.Session se =javax.mail.Session.getDefaultInstance(prop,mauth);

			//Creating the Message
			Message m = new MimeMessage(se);

			//Setting the Recipents
			m.setRecipient(RecipientType.TO, new InternetAddress(
				c.getEmail()));

		/*	InternetAddress[] dostoKeAdd = new InternetAddress[2];
			dostoKeAdd[0] = new InternetAddress(c.getEmail());
			dostoKeAdd[1] = new InternetAddress("karanahuja011@gmail.com");*/

			//m.setRecipients(RecipientType.TO, dostoKeAdd);

			// m.setRecipient(RecipientType.TO, new InternetAddress(
			// "ramanahuja188@gmail.com"));

			
			//setting the headers
			m.setFrom(new InternetAddress("ramanahuja188@gmail.com"));

			m.setSubject("WELCOME MAIL FROM CYBER PARLIAMENT :-) ");

			// The message -- Craeting Bodypart
			BodyPart bpMessage = new MimeBodyPart();
			bpMessage.setText("TO CONFIRM YOUR REGISTRATION , YOUR ID FOR LOGIN IS:"+c.getUsername() + "_" + c.getPassword());

			// // Attachment == Creating MimeBodypart
			/*MimeBodyPart bpAttach = new MimeBodyPart();
			bpAttach.attachFile(new File("result.png"));*/

			Multipart mp = new MimeMultipart();
			mp.addBodyPart(bpMessage);
			m.setContent(mp);

			//Sendnig the Mail using Transport Class
			Transport.send(m);

			System.out.println("Mail Sent Successfully ");
return "success";
		} catch (MessagingException e) {
			
			System.out.println("Messgaing Exception : " + e.getMessage());
			e.printStackTrace();
			return "error";
		} catch (Exception e) {
			System.out.println("Eception " + e.getMessage());
			e.printStackTrace();
			return "error";
		}

	}
	public String check()
	{
		int j = 0;
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query queryResult = ses
				.createQuery("from Client where username='"+c.getUsername()+"'");
		List<Client> Users;
		Users = (ArrayList<Client>) queryResult.list();
		if (Users.size() == 1) {
			j = 1;
		}
		ses.getTransaction().commit();
		ses.close();
		if (j == 1) {
			return "true";
		} else
			return "false";	
	}
}