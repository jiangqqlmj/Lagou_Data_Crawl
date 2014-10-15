package com.jousp.model;

/**
 * 职位详情信息实体类
 * 
 * @author apple
 * 
 */
public class JobDetailsModel {
	private String title; // 职位名称
	private String department; // 部门
	private String request; // 职位要求，这边以","进行隔开
	private String temptation; // 职位诱惑
	private String date; // 发布时间
	private String description; // 职位描述

	public JobDetailsModel() {
		super();
	}

	public JobDetailsModel(String title, String department, String request,
			String temptation, String date, String description) {
		super();
		this.title = title;
		this.department = department;
		this.request = request;
		this.temptation = temptation;
		this.date = date;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getTemptation() {
		return temptation;
	}

	public void setTemptation(String temptation) {
		this.temptation = temptation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "JobDetailsModel [title=" + title + ", department=" + department
				+ ", request=" + request + ", temptation=" + temptation
				+ ", date=" + date + ", description=" + description + "]";
	}

}
