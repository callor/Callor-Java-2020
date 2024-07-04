package com.callor.mybatis.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;

public class DataSourceFactoryImpl implements DataSourceFactory {

	private Properties prop;

	@Override
	public DataSource getDataSource() {

		PooledDataSource ds = new PooledDataSource();
		ds.setDriver(prop.getProperty("com.mysql.cj.jdbc.Driver"));
		ds.setUrl(prop.getProperty("jdbc:mysql://192.168.0.220/ai_callor"));
		ds.setUsername(prop.getProperty("root"));
		ds.setPassword(prop.getProperty("!Korea8085"));

		return ds;
	}

	@Override
	public void setProperties(Properties prprts) {
		prop = prprts;
	}

}
