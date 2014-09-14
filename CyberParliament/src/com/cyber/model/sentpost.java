package com.cyber.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class sentpost {
	String clientid;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	long sentpostid;
	String post;
	String postusername;
	String status;
	String department;
	@Temporal(TemporalType.DATE)
	java.util.Date sentdate;
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public long getSentpostid() {
		return sentpostid;
	}
	public void setSentpostid(long sentpostid) {
		this.sentpostid = sentpostid;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public java.util.Date getSentdate() {
		return sentdate;
	}
	public void setSentdate(java.util.Date sentdate) {
		this.sentdate = sentdate;
	}
}
