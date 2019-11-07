package com.callor.dbms.make;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class MakeCryptEx_01 {

	public static void main(String[] args) {

		System.out.println(System.getenv("CALLOR"));
		System.getenv().get("BIZ");
		
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();

		pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		pbeEnc.setPassword("com.biz.bbs"); // PBE 값(XML PASSWORD설정)

		String urlText = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String userText = "user4";
		String passwordText = "user4";
		
		String url = pbeEnc.encrypt(urlText);
		String username = pbeEnc.encrypt(userText);
		String password = pbeEnc.encrypt(passwordText);

		System.out.printf("URL : %s -> %s\n",urlText,url);
		System.out.printf("USER : %s -> %s\n",userText, username);
		System.out.printf("PASSWORD : %s -> %s\n" ,passwordText,password);

	}

}
