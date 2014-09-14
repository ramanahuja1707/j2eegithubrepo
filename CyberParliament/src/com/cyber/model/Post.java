package com.cyber.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post {
	String clientid;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	long postid;
	String post;
	String postusername;
	String status;
	int likes;
	ArrayList<String> wholiked =new ArrayList<>();
	public ArrayList<String> getWholiked() {
		return wholiked;
	}

	public void setWholiked(ArrayList<String> wholiked) {
		this.wholiked = wholiked;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	String mailed;
	String department;
	@Temporal(TemporalType.DATE)
	java.util.Date postdate;
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	public long getPostid() {
		return postid;
	}

	public void setPostid(long postid) {
		this.postid = postid;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPostusername() {
		return postusername;
	}

	public void setPostusername(String postusername) {
		this.postusername = postusername;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMailed() {
		return mailed;
	}

	public void setMailed(String mailed) {
		this.mailed = mailed;
	}

	public java.util.Date getPostdate() {
		return postdate;
	}

	public void setPostdate(java.util.Date postdate) {
		this.postdate = postdate;
	}

}
