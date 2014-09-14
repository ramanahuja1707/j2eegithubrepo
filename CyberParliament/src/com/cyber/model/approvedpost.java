package com.cyber.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class approvedpost {
	String clientid;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	long approvedpostid;
	String post;
	String postusername;
	String statusofapproval;
	String department;
	@Temporal(TemporalType.DATE)
	java.util.Date approvaldate;
	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public long getApprovedpostid() {
		return approvedpostid;
	}
	public void setApprovedpostid(long approvedpostid) {
		this.approvedpostid = approvedpostid;
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
	public String getStatusofapproval() {
		return statusofapproval;
	}
	public void setStatusofapproval(String statusofapproval) {
		this.statusofapproval = statusofapproval;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public java.util.Date getApprovaldate() {
		return approvaldate;
	}
	public void setApprovaldate(java.util.Date approvaldate) {
		this.approvaldate = approvaldate;
	}

}
