package com.callor.mybatis.config;


import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.callor.mybatis.mapper.BookMapperDao;
import com.callor.mybatis.mapper.MapperDao;
import com.callor.mybatis.model.BookVO;


public class SqlSessionConnec {
	
	private static SqlSessionFactory sqlSessionFactory;
	static {

		DataSourceFactory dataSourceFactory = new DataSourceFactoryImpl();
		
		DataSource dataSource = dataSourceFactory.getDataSource();
		
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		
		configuration.setLazyLoadingEnabled(true);

		// VO 클래스 Alias 설정(alias, Class), 여러개 추가
		configuration.getTypeAliasRegistry().registerAlias("Book",BookVO.class);
		
		// Mapper 추가(여러개 추가)
		configuration.addMapper(MapperDao.class);
		configuration.addMapper(BookMapperDao.class);

		// SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// SqlSessionFactory factory = builder.build(configuration);
		
		// builder 패턴
		if(sqlSessionFactory == null) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);	
		}
	}
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession(true);
	}
	
}
