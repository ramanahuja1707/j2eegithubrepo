package com.cyber.in;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.omg.CORBA.Request;

import com.cyber.model.Post;
import com.opensymphony.xwork2.ActionSupport;

public class ClientAccess extends ActionSupport implements SessionAware
		 {
	private List<Post> posttohome = new ArrayList<>();
String poststatus;
	public String getPoststatus() {
	return poststatus;
}

public void setPoststatus(String poststatus) {
	this.poststatus = poststatus;
}
	private String post;
	private  String department;
	private Post p = new Post();
	Map m;
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	public List<Post> getPosttohome() {
		return posttohome;
	}

	public void setPosttohome(List<Post> posttohome) {
		this.posttohome = posttohome;
	}

	public Post getP() {
		return p;
	}

	public void setP(Post p) {
		this.p = p;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String postsomething() {
		try {
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session ses = sf.openSession();
			ses.beginTransaction();
			//p.setDepartment(getDepartment());
			p.setClientid(m.get("username") + "_" + m.get("password"));
			p.setMailed("notmailed");
		//	p.setPost(getPost());
			p.setPostdate(new Date());
			p.setPostusername(m.get("username").toString());
			p.setStatus("posted");
			p.setLikes(0);
			p.setWholiked(null);
			ses.save(p);
			ses.getTransaction().commit();
			ses.close();
			setPoststatus("Post successfully posted!!!!!");
			return "postedsuccess";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			setPoststatus("Post failed!!!");
			return "postederror";
		}
	}

	public String execute() {
	return SUCCESS;	
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		m = arg0;
	}
	public String seepost()
	{
		if (m.get("username") != null &&
				  m.get("password") != null) {

			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session ses = sf.openSession();
			ses.beginTransaction();
			Query q = ses.createQuery("from Post");
			List<Post> obtained = (ArrayList<Post>) q.list();
			setPosttohome(obtained);
				m.put("posttohome", (ArrayList<Post>)obtained);
				return "postsuccess";
		}
		else
		{
			return "posterror";
		}
	}
}
