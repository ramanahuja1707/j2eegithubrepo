package com.cyber.in;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cyber.model.Post;
import com.cyber.model.sentpost;
import com.opensymphony.xwork2.ActionSupport;

public class sent extends ActionSupport implements SessionAware {
List<sentpost> obtainedsentpost=new ArrayList<sentpost>();
String sentsuccess;
	Map m;
		
	public String getSentsuccess() {
	return sentsuccess;
}

public void setSentsuccess(String sentsuccess) {
	this.sentsuccess = sentsuccess;
}
	public List<sentpost> getObtainedsentpost() {
	return obtainedsentpost;
}

public void setObtainedsentpost(List<sentpost> obtainedsentpost) {
	this.obtainedsentpost = obtainedsentpost;
}
	@Override
	public String execute() throws Exception {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session ses = sf.openSession();
			ses.beginTransaction();
			Query q = ses.createQuery("from sentpost where status='"+"mailed"+"'");
			List<sentpost> obtained = (ArrayList<sentpost>) q.list();
			setObtainedsentpost(obtained);
			if(obtained.size()>0)
			{
				return "sentpostsuccess";
				
			}else
			{
				setSentsuccess("NO DATA FOUND!!!");
				return "sentpostnodata";
			}
			
		} 

	@Override
	public void setSession(Map<String, Object> arg0) {
		m = arg0;

	}
}
