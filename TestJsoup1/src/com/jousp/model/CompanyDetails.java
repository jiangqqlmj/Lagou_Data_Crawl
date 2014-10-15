package com.jousp.model;

import java.util.List;

/**
 * 公司主页以及招聘界面详情
 * @author apple
 *
 */
public class CompanyDetails {
    private String title;         //公司简称
    private String logo;          //logo图片
    private String company;      //公司名字
    private String summary;       //公司简介
    private String temptation;    //职位诱惑
    private String introducation;    //公司介绍
    private List<JobListModel> mJobListModels;  //正在招聘的职位列表
    private String location;     //公司地点
    private String domain;       //领域
    private String scale;       //规模
    private String home;      //主页
    private String phase;     //阶段
    private String invest;    //投资机构
    private List<MemberModel> mMemberModels;  //创始人列表
    private List<ReportModel> mReportModels;  //公司新闻深度报道列表
	public CompanyDetails() {
		super();
	}
	public CompanyDetails(String title, String logo, String company,
			String summary, String temptation, String introducation,
			List<JobListModel> mJobListModels, String location, String domain,
			String scale, String home, String phase, String invest,
			List<MemberModel> mMemberModels, List<ReportModel> mReportModels) {
		super();
		this.title = title;
		this.logo = logo;
		this.company = company;
		this.summary = summary;
		this.temptation = temptation;
		this.introducation = introducation;
		this.mJobListModels = mJobListModels;
		this.location = location;
		this.domain = domain;
		this.scale = scale;
		this.home = home;
		this.phase = phase;
		this.invest = invest;
		this.mMemberModels = mMemberModels;
		this.mReportModels = mReportModels;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTemptation() {
		return temptation;
	}
	public void setTemptation(String temptation) {
		this.temptation = temptation;
	}
	public String getIntroducation() {
		return introducation;
	}
	public void setIntroducation(String introducation) {
		this.introducation = introducation;
	}
	public List<JobListModel> getmJobListModels() {
		return mJobListModels;
	}
	public void setmJobListModels(List<JobListModel> mJobListModels) {
		this.mJobListModels = mJobListModels;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getInvest() {
		return invest;
	}
	public void setInvest(String invest) {
		this.invest = invest;
	}
	public List<MemberModel> getmMemberModels() {
		return mMemberModels;
	}
	public void setmMemberModels(List<MemberModel> mMemberModels) {
		this.mMemberModels = mMemberModels;
	}
	public List<ReportModel> getmReportModels() {
		return mReportModels;
	}
	public void setmReportModels(List<ReportModel> mReportModels) {
		this.mReportModels = mReportModels;
	}
	@Override
	public String toString() {
		return "CompanyDetails [title=" + title + ", logo=" + logo
				+ ", company=" + company + ", summary=" + summary
				+ ", temptation=" + temptation + ", introducation="
				+ introducation + ", mJobListModels=" + mJobListModels
				+ ", location=" + location + ", domain=" + domain + ", scale="
				+ scale + ", home=" + home + ", phase=" + phase + ", invest="
				+ invest + ", mMemberModels=" + mMemberModels
				+ ", mReportModels=" + mReportModels + "]";
	}
    
}
