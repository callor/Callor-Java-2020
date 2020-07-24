package com.callor.mybatis.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;

public class DataSourceFactoryImpl implements DataSourceFactory{

	 private Properties prop;

	    @Override
	    public DataSource getDataSource() {

	        PooledDataSource ds = new PooledDataSource();

	        ds.setDriver(prop.getProperty("racle.jdbc.OracleDriver"));
	        ds.setUrl(prop.getProperty("dbc:oracle:thin:@localhost:1521:xe"));
	        ds.setUsername(prop.getProperty("user2"));
	        ds.setPassword(prop.getProperty("user2"));

	        return ds;
	    }

	    @Override
	    public void setProperties(Properties prprts) {
	        prop = prprts;
	    }
	    
	    
	
}
