package com.callor.url;

import java.net.URL;

public class ParseURL {

	public static void main(String[] args) throws Exception {

		URL aURL = new URL("https://callor.com:12200/main?name=korea");

		System.out.println("protocol = " + aURL.getProtocol());
		System.out.println("authority = " + aURL.getAuthority());
		System.out.println("host = " + aURL.getHost());
		System.out.println("port = " + aURL.getPort());
		System.out.println("path = " + aURL.getPath());
		System.out.println("query = " + aURL.getQuery());
		System.out.println("filename = " + aURL.getFile());
		System.out.println("ref = " + aURL.getRef());
	}

}
