package com.jousp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jousp.model.BannerModel;
import com.jousp.model.CompanyDetails;
import com.jousp.model.JobDetailsModel;
import com.jousp.model.JobListModel;
import com.jousp.model.JobModel;
import com.jousp.model.MemberModel;
import com.jousp.model.ReportModel;

/**
 * 进行解析拉钩网网站的一些信息
 * 
 * @author apple
 * 
 */
public class LagouTest {
	private List<BannerModel> mBannerModels; // 顶部轮播职位的集合
	private BannerModel bannerModel; // 顶部轮播职位实体类

	// 最热职位列表
	private List<JobModel> mHotModels;
	// 最新职位列表
	private List<JobModel> mLatestModels;
	// 最热职位信息实体类
	private JobModel jobModel;
	// 职位详情信息实体类
	private JobDetailsModel mJobDetailsModel;
	// 公司招聘主页
	private CompanyDetails mCompanyDetails;

	public static void main(String[] args) {
		new LagouTest().getData("http://www.lagou.com");
	}

	/**
	 * 进行职位信息数据获取
	 */
	public void getData(String url) {
		try {
			Document lagouDocument = Jsoup.connect(url).get();
			// 解析拉钩网轮播职位-顶部
			if (mBannerModels == null) {
				mBannerModels = new ArrayList<BannerModel>();
			}
			// 进行获取每条职位信息
			bannerModel = new BannerModel();
			// 第一条
			Element banner_bg_1 = lagouDocument
					.getElementsByClass("banner_bg_1").get(0).select("a")
					.get(0);
			// 标题和图片地址
			Element titleWithSrc_1 = banner_bg_1.select("img").get(0);
			bannerModel.setUrl(banner_bg_1.attr("href"));
			bannerModel.setTitle(titleWithSrc_1.attr("alt"));
			bannerModel.setImage(url + "/" + titleWithSrc_1.attr("src"));
			mBannerModels.add(bannerModel);
			// 第二条
			Element banner_bg_2 = lagouDocument
					.getElementsByClass("banner_bg_2").get(0).select("a")
					.get(0);
			// 标题和图片地址
			Element titleWithSrc_2 = banner_bg_2.select("img").get(0);
			bannerModel = new BannerModel();
			bannerModel.setUrl(banner_bg_2.attr("href"));
			bannerModel.setTitle(titleWithSrc_2.attr("alt"));
			bannerModel.setImage(url + "/" + titleWithSrc_2.attr("src"));
			mBannerModels.add(bannerModel);
			// 第三条
			Element banner_bg_3 = lagouDocument
					.getElementsByClass("banner_bg_3").get(0).select("a")
					.get(0);
			// 标题和图片地址
			Element titleWithSrc_3 = banner_bg_3.select("img").get(0);
			bannerModel = new BannerModel();
			bannerModel.setUrl(banner_bg_3.attr("href"));
			bannerModel.setTitle(titleWithSrc_3.attr("alt"));
			bannerModel.setImage(url + "/" + titleWithSrc_3.attr("src"));
			mBannerModels.add(bannerModel);
			// 顶部另外5个轮播职位-较小
			Element da_thumbsElement = lagouDocument
					.getElementById("da-thumbs");
			Elements da_thumbs_li_Elements = da_thumbsElement.select("li");
			for (Element element : da_thumbs_li_Elements) {
				// 开始解析数据
				Element da = element.select("a").get(0);
				bannerModel = new BannerModel();
				bannerModel.setUrl(da.attr("href"));
				bannerModel.setTitle(da.select("img").get(0).attr("alt"));
				bannerModel.setImage(da.select("img").get(0).attr("src"));
				mBannerModels.add(bannerModel);
			}
			 for (BannerModel bannerModel : mBannerModels) {
			 System.out.println(bannerModel);
			 }
			// =========顶部轮播职位信息解析完毕===========================
			// =========开始解析下面最热职位信息===========================
			Elements hotList = lagouDocument.getElementById("hotList")
					.getElementsByClass("hot_pos").get(0)
					.getElementsByClass("clearfix");
			mHotModels = new ArrayList<JobModel>();
			for (Element element : hotList) {
				jobModel = new JobModel();
				// 职位基本信息
				Element hot_pos_l = element.select("div.hot_pos_l").get(0);
				// 职位名称
				jobModel.setTitle(hot_pos_l.select("a").get(0).text());
				// 职位详情界面
				jobModel.setJobUrl(hot_pos_l.select("a").get(0).attr("href"));
				// 职位地点-去掉前后的[]
				String location = hot_pos_l.select("span").get(0).text();
				int beferPrex = location.indexOf("[");
				int afterPrex = location.indexOf("]");
				jobModel.setLocation(location.substring(beferPrex + 1,
						afterPrex));

				Elements c7Elements = hot_pos_l.getElementsByClass("c7");
				for (Element element2 : c7Elements) {
					String emText = element2.select("em").get(0).text();
					if (emText.startsWith("月薪")) {
						String salary = hot_pos_l.select("span").get(1).text();
						jobModel.setSalary(salary.substring("月薪:".length(),
								salary.length()).trim());
					} else if (emText.startsWith("经验")) {
						String experience = hot_pos_l.select("span").get(2)
								.text();
						jobModel.setExperience(experience.substring(
								"经验:".length(), experience.length()).trim());
					} else if (emText.startsWith("最低学历")) {
						String education = hot_pos_l.select("span").get(3)
								.text();
						jobModel.setEducation(education.substring(
								"最低学历:".length(), education.length()).trim());
					} else if (emText.startsWith("职位诱惑")) {
						String temptation = hot_pos_l.select("span").get(4)
								.text();
						jobModel.setTemptation(temptation.substring(
								"职位诱惑:".length(), temptation.length()).trim());
					}
				}
				// 发布日期
				jobModel.setDate(hot_pos_l.select("span").get(5).text());
				// 职位其他信息
				Element hot_pos_r = element.select("div.hot_pos_r").get(0);
				// 公司名称
				jobModel.setCompany(hot_pos_r.select("a").get(0).text());
				// 发布地址公司地址
				jobModel.setGongsiUrl(hot_pos_r.select("a").get(0).attr("href"));
				Elements c7Elements_r = hot_pos_r.select("span");
				for (Element element2 : c7Elements_r) {
					String spanText = element2.text();
					if (spanText.startsWith("领域")) {
						jobModel.setDomain(spanText.substring("领域:".length(),
								spanText.length()).trim());
					} else if (spanText.startsWith("创始人")) {
						jobModel.setFounder(spanText.substring("创始人:".length(),
								spanText.length()).trim());
					} else if (spanText.startsWith("阶段")) {
						jobModel.setPhase(spanText.substring("阶段:".length(),
								spanText.length()).trim());
					} else if (spanText.startsWith("规模")) {
						jobModel.setScale(spanText.substring("规模:".length(),
								spanText.length()).trim());
					}
				}
				// 附件条件
				Elements tagsElements = hot_pos_r.select("ul").get(0)
						.select("li");
				StringBuffer tag = new StringBuffer();
				for (Element element2 : tagsElements) {
					tag.append(element2.text()).append(",");
				}
				String additional = new String(tag);
				if (additional != null && !additional.equals("")) {
					jobModel.setAdditional(additional.substring(0,
							additional.length() - 1));
				} else {
					jobModel.setAdditional("");
				}
				mHotModels.add(jobModel);
			}
            for (JobModel model : mHotModels) {
				System.out.println(model);
			}
			// =============最热职位解析完成===================
			// =============开始解析最新职位===================
			Elements lastest = lagouDocument.getElementById("hotList")
					.getElementsByClass("hot_pos").get(1)
					.getElementsByClass("clearfix");
			// System.out.println(lastest);
			mLatestModels = new ArrayList<JobModel>();
			for (Element element : lastest) {
				jobModel = new JobModel();
				// 职位基本信息
				Element hot_pos_l = element.select("div.hot_pos_l").get(0);
				// 职位名称
				jobModel.setTitle(hot_pos_l.select("a").get(0).text());
				// 职位详情界面
				jobModel.setJobUrl(hot_pos_l.select("a").get(0).attr("href"));
				// 职位地点-去掉前后的[]
				String location = hot_pos_l.select("span").get(0).text();
				int beferPrex = location.indexOf("[");
				int afterPrex = location.indexOf("]");
				jobModel.setLocation(location.substring(beferPrex + 1,
						afterPrex));
				Elements c7Elements = hot_pos_l.getElementsByClass("c7");
				for (Element element2 : c7Elements) {
					String emText = element2.select("em").get(0).text();
					if (emText.startsWith("月薪")) {
						String salary = hot_pos_l.select("span").get(1).text();
						jobModel.setSalary(salary.substring("月薪:".length(),
								salary.length()).trim());
					} else if (emText.startsWith("经验")) {
						String experience = hot_pos_l.select("span").get(2)
								.text();
						jobModel.setExperience(experience.substring(
								"经验:".length(), experience.length()).trim());
					} else if (emText.startsWith("最低学历")) {
						String education = hot_pos_l.select("span").get(3)
								.text();
						jobModel.setEducation(education.substring(
								"最低学历:".length(), education.length()).trim());
					} else if (emText.startsWith("职位诱惑")) {
						String temptation = hot_pos_l.select("span").get(4)
								.text();
						jobModel.setTemptation(temptation.substring(
								"职位诱惑:".length(), temptation.length()).trim());
					}
				}
				// 发布日期
				jobModel.setDate(hot_pos_l.select("span").get(5).text());
				// 职位其他信息
				Element hot_pos_r = element.select("div.hot_pos_r").get(0);
				// 公司名称
				jobModel.setCompany(hot_pos_r.select("a").get(0).text());
				// 发布地址公司地址
				jobModel.setGongsiUrl(hot_pos_r.select("a").get(0).attr("href"));
				Elements c7Elements_r = hot_pos_r.select("span");
				for (Element element2 : c7Elements_r) {
					String spanText = element2.text();
					if (spanText.startsWith("领域")) {
						jobModel.setDomain(spanText.substring("领域:".length(),
								spanText.length()).trim());
					} else if (spanText.startsWith("创始人")) {
						jobModel.setFounder(spanText.substring("创始人:".length(),
								spanText.length()).trim());
					} else if (spanText.startsWith("阶段")) {
						jobModel.setPhase(spanText.substring("阶段:".length(),
								spanText.length()).trim());
					} else if (spanText.startsWith("规模")) {
						jobModel.setScale(spanText.substring("规模:".length(),
								spanText.length()).trim());
					}
				}
				// 附件条件
				Elements tagsElements = hot_pos_r.select("ul").get(0)
						.select("li");
				StringBuffer tag = new StringBuffer();
				for (Element element2 : tagsElements) {
					tag.append(element2.text()).append(",");
				}
				String additional = new String(tag);
				if (additional != null && !additional.equals("")) {
					jobModel.setAdditional(additional.substring(0,
							additional.length() - 1));
				} else {
					jobModel.setAdditional("");
				}
				mLatestModels.add(jobModel);
			}
			for (JobModel model : mLatestModels) {
				System.out.println(model);
			}
			// ============最新职位解析完成=================
			// ============开始进行解析职位详情=============
			Document lagouDetailsDocument = Jsoup.connect(
					"http://www.lagou.com/jobs/269253.html?source=home_hot")
					.get();
			Element jobDetalsElement = lagouDetailsDocument.getElementsByClass(
					"job_detail").get(0);
			mJobDetailsModel = new JobDetailsModel();
			// 部门
			mJobDetailsModel.setDepartment(jobDetalsElement.select("dt").get(0)
					.select("h1").get(0).select("div").get(0).text());
			// 职位
			mJobDetailsModel.setTitle(jobDetalsElement.select("dt").get(0)
					.select("h1").get(0).attr("title"));
			// 职位要求
			Element jobRequestElement = jobDetalsElement.select(
					"dd.job_request").get(0);
			Elements spanElements = jobRequestElement.select("span");
			StringBuffer temptation = new StringBuffer();
			for (Element element : spanElements) {
				temptation.append(element.text()).append(",");
			}
			String result = new String(temptation.deleteCharAt(temptation
					.length() - 1));
			mJobDetailsModel.setRequest(result);
			// 职位诱惑
			String request = jobRequestElement.text();
			int indexTemptation = request.indexOf("职位诱惑");
			int indexDate = request.indexOf("发布时间");
			mJobDetailsModel.setTemptation(request.substring(
					indexTemptation + 6, indexDate - 1).trim());
			// 职位时间
			String date = jobRequestElement.select("div").get(0).text().trim();
			mJobDetailsModel.setDate(date.substring("发布时间:".length(),
					date.length()).trim());
			// 职位描述
			Element jobBtElement = jobDetalsElement.select("dd.job_bt").get(0);
			Elements descriptionElements = jobBtElement.select("p");
			StringBuffer desciption = new StringBuffer();
			for (Element element : descriptionElements) {
				desciption.append(element.text()).append("\n");
			}
			mJobDetailsModel.setDescription(desciption.toString());
			System.out.println(mJobDetailsModel);
			// ==================职位详情解析成功===============================
			// ==================开始解析公司主页基本以及招聘职位信息==============
			Document lagouGongsiDocument = Jsoup.connect(
					"http://www.lagou.com/gongsi/4510.html").get();
			mCompanyDetails = new CompanyDetails();
			Element job_detail = lagouGongsiDocument.select("div.c_detail")
					.get(0);
			// logo图片
			mCompanyDetails.setLogo(job_detail.getElementById("logoShow")
					.select("img").get(0).attr("src"));
			Element c_box = job_detail.getElementsByClass("c_box").get(0);
			// 公司简称
			mCompanyDetails.setTitle(c_box.select("h2").get(0).text());
			// 公司名字
			mCompanyDetails.setCompany(c_box.select("h1").get(0).text());
			// 公司简介
			Element element = c_box.select("div").get(3);
			String summary = element.text();
			summary = summary.substring(4, summary.length());
			// &nbsp
			mCompanyDetails.setSummary(summary.substring(0,
					summary.length() - 2));
			// 职位诱惑
			Elements lablesElements = c_box.select("ul.clearfix").get(0)
					.select("li");
			StringBuffer lables = new StringBuffer();
			for (Element element2 : lablesElements) {
				lables.append(element2.text()).append(",");
			}
			lables.deleteCharAt(lables.length() - 1);
			mCompanyDetails.setTemptation(lables.toString());
			// 公司介绍
			Element c_section = lagouGongsiDocument.getElementsByClass(
					"c_section").get(0);
			mCompanyDetails.setIntroducation(c_section
					.getElementsByClass("c_intro").get(0).text());
			//正在招聘中职位列表
			List<JobListModel> mJobListModels=new ArrayList<JobListModel>();
			Elements jobList= lagouGongsiDocument.getElementById("jobList").select("li");
			for (Element element2 : jobList) {
				JobListModel model=new JobListModel();
				Element aElement= element2.select("a").get(0);
				//职位详情界面
				model.setUrl(aElement.attr("href"));
				//职位名称
				Element h3Element=element2.select("h3").get(0);
				model.setTitle(h3Element.select("span.pos").get(0).text());
				//地点
				String location=h3Element.select("span").get(1).text();
				model.setLocation(location.substring(1, location.length()-1));
				//日期
				model.setDate(element2.select("span").get(2).text());
				//职位描述
				model.setDescription(aElement.select("div").get(0).text().trim());
				mJobListModels.add(model);
			}
			mCompanyDetails.setmJobListModels(mJobListModels);
			//公司地点
            Element content_r=lagouGongsiDocument.select("div.content_r").get(0);
            Elements tBody=content_r.select("div.c_tags").get(0).select("tbody");
            for (Element element2 : tBody) {
            	Elements tr=element2.select("tr");
            	for (Element element3 : tr) {
					//解析 地点，领域，规模 ，主页
            		String tdStr=element3.select("td").get(0).text();
            		Element tdValue=element3.select("td").get(1);
            		if(tdStr.equals("地点")){
            			mCompanyDetails.setLocation(tdValue.text());
            		}else if (tdStr.equals("领域")) {
						mCompanyDetails.setDomain(tdValue.text());
					}else if (tdStr.equals("规模")) {
						mCompanyDetails.setScale(tdValue.text());
					}else if (tdStr.equals("主页")) {
						mCompanyDetails.setHome(tdValue.select("a").get(0).attr("href"));
					}
				}
			}
            //阶段
            Elements resetElements= content_r.getElementsByClass("c_section").get(0).select("ul").get(0).select("li");
            mCompanyDetails.setPhase(resetElements.get(0).select("span").get(0).text());
            //投资机构
            mCompanyDetails.setInvest(resetElements.get(1).select("span").get(0).text());
            //创始人
            List<MemberModel> mMemberModels =new ArrayList<MemberModel>();
            Elements member_info= content_r.getElementsByClass("c_section").get(1).select("div.member_info");
            for (Element element2 : member_info) {
				MemberModel model=new MemberModel();
				//头像
				String portrait=element2.select("div.m_portrait").get(0).select("img").get(0).attr("src");
				model.setPortrait(portrait);
				//名字
				String name= element2.select("div.m_name").get(0).text().trim();
				model.setName(name);
				//职位
				model.setPosition(element2.select("div.m_position").get(0).text());
				//基本信息
				model.setDescription(element2.select("div.m_intro").get(0).text());
				mMemberModels.add(model);
			}
            mCompanyDetails.setmMemberModels(mMemberModels);
            //公司深度报道
            List<ReportModel> mReportModels = new ArrayList<ReportModel>();
            Elements reportElements= content_r.getElementsByClass("c_section").get(2).select("ul").get(0).select("a");
            for (Element element2 : reportElements) {
            	ReportModel model=new ReportModel();
            	model.setTitle(element2.text());
            	model.setUrl(element2.attr("href"));
            	mReportModels.add(model);
			}
            mCompanyDetails.setmReportModels(mReportModels);
            System.out.println(mCompanyDetails);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
