package com.websitedockergradle.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POSTS")
public class Posts {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",insertable=true, nullable = false)
	private long id;
	
	private String author;
	
	private String topic;
	
	private String body;
	
	private Date date_posted;
	
	private Date date_edited;
	
	public Posts() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}


	public Date getDate_posted() {
		return date_posted;
	}


	public void setDate_posted(Date date_posted) {
		this.date_posted = date_posted;
	}


	public Date getDate_edited() {
		return date_edited;
	}


	public void setDate_edited(Date date_edited) {
		this.date_edited = date_edited;
	}

	
	
	

}
