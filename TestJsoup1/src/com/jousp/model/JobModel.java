package com.jousp.model;

/**
 * 职位信息实体类(包括最热，最新职位列表信息)
 * 
 * @author apple
 * 
 */
public class JobModel {
	private String title; // 职位名称
	private String jobUrl; // 详情职位地址
	private String gongsiUrl; // 详情招聘职位公司地址
	private String company; // 公司名称
	private String salary; // 薪水
	private String experience; // 经验
	private String education; // 最低学历
	private String domain; // 领域
	private String founder; // 创始人
	private String temptation; // 职位诱惑
	private String date; // 发布日期
	private String phase; // 阶段
	private String scale; // 规模
	private String additional; // 附加信息
	private String location; // 地点

	public JobModel() {
		super();
	}

	public JobModel(String title, String jobUrl, String gongsiUrl,
			String company, String salary, String experience, String education,
			String domain, String founder, String temptation, String date,
			String phase, String scale, String additional, String location) {
		super();
		this.title = title;
		this.jobUrl = jobUrl;
		this.gongsiUrl = gongsiUrl;
		this.company = company;
		this.salary = salary;
		this.experience = experience;
		this.education = education;
		this.domain = domain;
		this.founder = founder;
		this.temptation = temptation;
		this.date = date;
		this.phase = phase;
		this.scale = scale;
		this.additional = additional;
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJobUrl() {
		return jobUrl;
	}

	public void setJobUrl(String jobUrl) {
		this.jobUrl = jobUrl;
	}

	public String getGongsiUrl() {
		return gongsiUrl;
	}

	public void setGongsiUrl(String gongsiUrl) {
		this.gongsiUrl = gongsiUrl;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
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

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "JobModel [title=" + title + ", jobUrl=" + jobUrl
				+ ", gongsiUrl=" + gongsiUrl + ", company=" + company
				+ ", salary=" + salary + ", experience=" + experience
				+ ", education=" + education + ", domain=" + domain
				+ ", founder=" + founder + ", temptation=" + temptation
				+ ", date=" + date + ", phase=" + phase + ", scale=" + scale
				+ ", additional=" + additional + ", location=" + location + "]";
	}

}
