package com.jousp;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.CORBA.NVList;

public class JSoupTest1 {
	public static void main(String[] args) {
		try {
			// http://blog.csdn.net/developer_jiangqq
			Document document = Jsoup.connect("http://www.wdh.la").get();
			// System.out.println(document);
			Element content = document.getElementById("login");
			Elements links = content.getElementsByTag("a");
			for (Element element : links) {
				String attr = element.attr("href");
				String text = element.text();
				System.out.println("attr=" + attr + ",text=" + text);
			}
			Elements linkshref = document.select("a[href]");
			for (Element element : linkshref) {
				String href = element.attr("href");
				String text = element.text();
				//System.out.println("href=" + href + ",text=" + text);
			}
			Elements pngs = document.select("img[src$=.png]");
			for (Element element : pngs) {
				String src = element.attr("src");
				String more = element.attr("alt");
				//System.out.println("src=" + src + ",alt=" + more);
			}
			//进行选择class 标签
			Element navElement= document.select("div.nav1").get(0);
			//System.out.println(navElement);
			//进行解析p
			String pTextString= navElement.getElementsByTag("p").get(0).text();
			System.out.println(pTextString);
			//进行解析li
			Elements liElements=navElement.select("li");
			for (Element element : liElements) {
				Element aElement= element.getElementsByTag("a").get(0);
				String href=aElement.attr("href");
				String text=aElement.text();
				//System.out.println("href="+href+",text="+text);
			}
			//System.out.println("li:\n"+liElements);
			//Elements resultLinks = document.select("h1.r > a"); //在h3元素之后的a元素
			//System.out.println(resultLinks);
			
			System.out.println("=====拉钩======");
			Document lagouDocument = Jsoup.connect("http://www.lagou.com/").get();
			Elements headerElements= lagouDocument.select("div.reset");
			System.out.println(headerElements);
			System.out.println("Html:"+headerElements.outerHtml());
			for (Element element : headerElements) {
				String idStr= element.id();
				String tagStr= element.tagName();
				String classStr= element.className();
				System.out.println("id="+idStr+",tag="+tagStr+",class="+classStr);
			}
			
			
//			String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
//			Document doc = Jsoup.parse(html);//解析HTML字符串返回一个Document实现
//			Element link = doc.select("a").first();//查找第一个a元素
//			String text = doc.body().text(); // "An example link"//取得字符串中的文本
//			System.out.println("text="+text);
//			String linkHref = link.attr("href"); // "http://example.com/"//取得链接地址
//			System.out.println("linkHref="+linkHref);
//			String linkText = link.text(); // "example""//取得链接地址中的文本
//            System.out.println("linkText="+linkText);
//			String linkOuterH = link.outerHtml(); 
//			    // "<a href="http://example.com"><b>example</b></a>"
//			System.out.println("linkOuterH="+linkOuterH);
//			String linkInnerH = link.html(); // "<b>example</b>"//取得链接内的html内容
//			System.out.println("linkInnerH="+linkInnerH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
