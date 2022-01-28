package com.callor.dbms.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class MakeCryptEx_01 {

	public static void main(String[] args) {

		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();

		System.out.println("PBEWithMD5AndDES 암호화") ;
		pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		pbeEnc.setPassword("jasyptPass"); // PBE 값(XML PASSWORD설정)

		String urlText = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String userText = "user4";
		String passwordText = "user4";
		
		String url = pbeEnc.encrypt(urlText);
		String username = pbeEnc.encrypt("system");
		String password = pbeEnc.encrypt("bogogt");

		System.out.printf("URL : %s -> %s\n",urlText,url);
		System.out.printf("USER : %s -> %s\n",userText, username);
		System.out.printf("PASSWORD : %s -> %s\n" ,passwordText,password);

		
		
		
		
		
	}

}
