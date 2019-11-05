package com.callor.dbms.exec;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class MakeCryptEx_02 {

	public static void main(String[] args) throws FileNotFoundException {

		
		Map<String, String> env = System.getenv();
		
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
		Scanner scanner = new Scanner(System.in);
		
		// DIGEST ALGORITHMS:   [MD2, MD5, SHA, SHA-256, SHA-384, SHA-512]
		// PBE ALGORITHMS:      [PBEWITHMD5ANDDES, PBEWITHMD5ANDTRIPLEDES, PBEWITHSHA1ANDDESEDE, PBEWITHSHA1ANDRC2_40]
		pbeEnc.setAlgorithm("PBEWITHSHA1ANDDESEDE");
		// pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		
		System.out.printf("암호화 Key(%s) >> ",env.get("JAVA_HOME"));
		String secKey = scanner.nextLine();
		if(secKey.trim().isBlank()) secKey = env.get("JAVA_HOME");
		
		pbeEnc.setPassword(secKey); // PBE 값(XML PASSWORD설정)

		String urlText = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		
		System.out.print("username >> ");
		String userNameText = scanner.nextLine();

		System.out.print("password >> ");
		String passwordText = scanner.nextLine();
		
		String url = pbeEnc.encrypt(urlText);
		String username = pbeEnc.encrypt(userNameText);
		String password = pbeEnc.encrypt(passwordText);

		System.out.printf("URL : %s -> %s\n",urlText,url);
		System.out.printf("USER : %s -> %s\n",userNameText, username);
		System.out.printf("PASSWORD : %s -> %s\n" ,passwordText,password);
		
		PrintWriter fileOut = null;
		
		fileOut = new PrintWriter("src/com/callor/dbms/config/security.txt");

		fileOut.printf("KEY : %s\n",secKey);
		fileOut.printf("URL : %s -> %s\n",urlText,url);
		fileOut.printf("USER : %s -> %s\n",userNameText, username);
		fileOut.printf("PASSWORD : %s -> %s\n" ,passwordText,password);
		
		fileOut.flush();
		fileOut.close();

		scanner.close();
		
	}

}
