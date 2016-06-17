package com.snpData.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

/*
 * The data entity 
 * */
public class SnpData implements Serializable{
	

	private long id;
	

	private long profile_id;
	

	private String s3key_name;
	

	private String s3bucket_name;
	
	
	/*  
	 * Constructors
	 * */
	public SnpData() {
		super();
	}

	public SnpData(long id, long profile_id, String s3key_name, String s3bucket_name) {
		super();
		this.id = id;
		this.profile_id = profile_id;
		this.s3key_name = s3key_name;
		this.s3bucket_name = s3bucket_name;
	}

	/*
	 * Getters and setters
	 * */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(long profile_id) {
		this.profile_id = profile_id;
	}

	public String getS3key_name() {
		return s3key_name;
	}

	public void setS3key_name(String s3key_name) {
		this.s3key_name = s3key_name;
	}

	public String getS3bucket_name() {
		return s3bucket_name;
	}

	public void setS3bucket_name(String s3bucket_name) {
		this.s3bucket_name = s3bucket_name;
	}

	@Override
	public String toString() {
		return "SleepingData [id=" + id + ", profile_id=" + profile_id + ", s3key_name=" + s3key_name
				+ ", s3bucket_name=" + s3bucket_name + "]";
	}
}
	