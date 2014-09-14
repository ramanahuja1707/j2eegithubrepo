package com.CloudPrinting.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class filedata {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long fileId;
	private String id;
private	String path;
	private String Status;
	private String printstatus;
	@Temporal(TemporalType.DATE)
	private Date d;
	private String data;
	private String name;
	private String filetype;
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getPrintstatus() {
		return printstatus;
	}
	public void setPrintstatus(String printstatus) {
		this.printstatus = printstatus;
	}
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
}
