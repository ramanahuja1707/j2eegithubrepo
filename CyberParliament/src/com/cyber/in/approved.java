package com.cyber.in;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cyber.model.approvedpost;
import com.opensymphony.xwork2.ActionSupport;

public class approved extends ActionSupport implements SessionAware {
	Map m;
	List<approvedpost> obtainedapprovedpost=new ArrayList<approvedpost>();
@Override
public String execute() throws Exception {
	SessionFactory sf = new Configuration().configure()
			.buildSessionFactory();
	Session ses = sf.openSession();
	ses.beginTransaction();
	Query q = ses.createQuery("from approvedpost where statusofapproval='"+"approved"+"'");
	List<approvedpost> obtained = (ArrayList<approvedpost>) q.list();
	setObtainedapprovedpost(obtained);
	if(obtained.size()>0)
	{
		return "approvedpostsuccess";
		
	}else
	{
		return "approvedpostnodata";
	}
}

@Override
public void setSession(Map<String, Object> arg0) {
	m=arg0;
	
}
public List<approvedpost> getObtainedapprovedpost() {
	return obtainedapprovedpost;
}

public void setObtainedapprovedpost(List<approvedpost> obtainedapprovedpost) {
	this.obtainedapprovedpost = obtainedapprovedpost;
}

}
