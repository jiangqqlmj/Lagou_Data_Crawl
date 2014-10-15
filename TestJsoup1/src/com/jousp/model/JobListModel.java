package com.jousp.model;

/**
 * 公司主页介绍中 正在招聘的职位列表信息实体类
 * 
 * @author apple
 * 
 */
public class JobListModel {
	private String url; // 职位详情界面
	private String title; // 职位名称
	private String location; // 地点
	private String date; // 发布时间
	private String description; // 职位描述

	public JobListModel() {
		super();
	}

	public JobListModel(String url, String title, String location, String date,
			String description) {
		super();
		this.url = url;
		this.title = title;
		this.location = location;
		this.date = date;
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
		return "JobListModel [url=" + url + ", title=" + title + ", location="
				+ location + ", date=" + date + ", description=" + description
				+ "]";
	}

}
