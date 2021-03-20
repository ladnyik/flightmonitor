package com.flightmonitor.application.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupTester {

	public static void main(String[] args) {

		Document doc = Jsoup.parse("<html></html>");	
		Element link = doc.body().appendElement("a");
		link.text("csa");
		link.attr("href","https://www.index.hu");
		System.out.println(doc);
		
	}

}
