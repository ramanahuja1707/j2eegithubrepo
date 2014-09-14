package com.cyber.in;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cyber.model.Client;
import com.cyber.model.Post;
import com.opensymphony.xwork2.ActionSupport;

public class likepost extends ActionSupport implements SessionAware {
	Map m;
	private List<Post> posttohome = new ArrayList<>();
	String likestatus;
	String post;
	public String getLikestatus() {
		return likestatus;
	}

	public List<Post> getPosttohome() {
		return posttohome;
	}

	public void setPosttohome(List<Post> posttohome) {
		this.posttohome = posttohome;
	}

	public void setLikestatus(String likestatus) {
		this.likestatus = likestatus;
	}
	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		m = arg0;
	}

	@Override
	public String execute() throws Exception {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query queryResult = ses.createQuery("from Post where  post='"
				+ getPost() + "'");
		List<Post> Users;
		Users = (List<Post>) queryResult.list();
		System.out.println(Users.size());
		System.out.println(getPost());
		if (Users.size() == 1) {
			for (Post p1 : Users) {
				p1.setLikes(p1.getLikes() + 1);
				ses.update(p1);
				ses.getTransaction().commit();
				ses.close();
				calculatepost();
			}
			return "likesuccess";
		} else {
			ses.getTransaction().commit();
			ses.close();
			calculatepost();
			return "likefailure";
		}
	}
	public String unlike()
	{
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query queryResult = ses.createQuery("from Post where  post='"
				+ getPost() + "'");
		List<Post> Users;
		Users = (List<Post>) queryResult.list();
		System.out.println(Users.size());
		System.out.println(getPost());
		if (Users.size() == 1) {
			for (Post p1 : Users) {
				p1.setLikes(p1.getLikes() - 1);
				ses.update(p1);
				ses.getTransaction().commit();
				ses.close();
				calculatepost();
			}
			return "unlikesuccess";
		} else {
			ses.getTransaction().commit();
			ses.close();
			calculatepost();
			return "unlikefailure";
		}
	}
	public void calculatepost()
	{
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Query q = ses.createQuery("from Post");
		List<Post> obtained = (ArrayList<Post>) q.list();
		setPosttohome(obtained);
			m.put("posttohome", (ArrayList<Post>)obtained);
	}
}
