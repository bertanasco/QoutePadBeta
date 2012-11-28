package org.mobiletao.qoutepad.model;

import java.util.Date;

public class Qoute {
	private String id;
	private String title;
	private Author author;
	private String link;
	private String filePath;
	private String sample;
	private Date uploadDate;
	private Date expirationDate;
	
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public void setSample(String sample){
		this.sample = sample;
	}
	public String getSample(){
		return sample;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	@Override
	public String toString (){
		return "Qoute [id=" + id + ", title=" + title; 
	}

}
