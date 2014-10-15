package com.jousp.model;

/**
 * 公司新闻深度报道
 * 
 * @author apple
 * 
 */
public class ReportModel {
	private String title; // 标题
	private String url; // 链接地址

	public ReportModel() {
		super();
	}

	public ReportModel(String title, String url) {
		super();
		this.title = title;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ReportModel [title=" + title + ", url=" + url + "]";
	}

}
