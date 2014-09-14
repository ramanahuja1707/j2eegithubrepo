package com.cyber.in;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {

	PasswordAuthentication pass;

	public MyAuthenticator(String emailId, String password) {
		pass = new PasswordAuthentication(emailId, password);
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return pass;
	}

}
