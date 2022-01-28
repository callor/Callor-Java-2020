package com.callor.dbms.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnection {
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		
		// *-config.xml 파일을 읽어서 
		// mybatis 초기 설정값을 가져오기
		String configFile = "com/callor/dbms/config/mybatis-config.xml";
		InputStream inputStream = null;
		
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
		pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		pbeEnc.setPassword("com.callor"); // PBE 값(XML PASSWORD설정)
		
		Properties prop = new Properties(); 
		prop.put("username", pbeEnc.decrypt("OFnImVoaC0lFm4/OMH/VDw=="));
		prop.put("password", pbeEnc.decrypt("oEe0krUUh94i8MpCOtLGLg=="));
		
		try {
			// configFile을 읽어오는 절차
			inputStream = Resources.getResourceAsStream(configFile);
			
			// sqlSessionFactory를 싱글톤으로 생성하기 위한 절차
			SqlSessionFactoryBuilder builder
				= new SqlSessionFactoryBuilder();
			if(sqlSessionFactory == null ) {
				
				sqlSessionFactory = builder.build(inputStream,prop);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} //  end static
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
