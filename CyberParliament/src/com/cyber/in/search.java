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
import com.opensymphony.xwork2.ActionSupport;

public class search extends ActionSupport implements SessionAware {
	String department;
	String post;
	List<Post> posttosearch = new ArrayList<Post>();
	Map m;

	@Override
	public String execute() throws Exception {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query q = ses.createQuery("from Post where department='"
				+ getDepartment() + "'");
		List<Post> obtained = (ArrayList<Post>) q.list();
		setPosttosearch(obtained);
		if (obtained.size() > 0)
			return "posttosearchsuccess";
		else
			return "posttonodata";
	}
	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public List<Post> getPosttosearch() {
		return posttosearch;
	}

	public void setPosttosearch(List<Post> posttosearch) {
		this.posttosearch = posttosearch;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		m = arg0;

	}
}
