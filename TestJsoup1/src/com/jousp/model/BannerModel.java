package com.jousp.model;

/**
 * 顶部轮播职位信息
 * 
 * @author apple
 * 
 */
public class BannerModel {
	private String title;
	private String url;
	private String image;

	public BannerModel() {
		super();
	}

	public BannerModel(String title, String url, String image) {
		super();
		this.title = title;
		this.url = url;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "BannerModel [title=" + title + ", url=" + url + ", image="
				+ image + "]";
	}

}
