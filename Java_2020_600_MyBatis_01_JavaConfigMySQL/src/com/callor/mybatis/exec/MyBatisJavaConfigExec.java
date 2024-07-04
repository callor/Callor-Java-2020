package com.callor.mybatis.exec;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.callor.mybatis.config.DataSourceFactoryImpl;
import com.callor.mybatis.mapper.VisionMapper;

public class MyBatisJavaConfigExec {

	private static SqlSessionFactory sesFact = null;

    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        prop.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        prop.setProperty("url", "jdbc:mysql://192.168.0.220:3306/ai_callor");
        prop.setProperty("user", "root");
        prop.setProperty("password", "!Korea8085");
        prop.setProperty("type", "POOLED");

        DataSourceFactory mdsf = new DataSourceFactoryImpl();
        mdsf.setProperties(prop);
        
        DataSource ds = mdsf.getDataSource();
        
        

        TransactionFactory trFact = new JdbcTransactionFactory();
        Environment environment = new Environment("development", trFact, ds);
        Configuration config = new Configuration(environment);
        
        config.addMapper(VisionMapper.class);

        sesFact = new SqlSessionFactoryBuilder().build(config);

        try (SqlSession session = sesFact.openSession()) {
            int numOfBooks = session.selectOne("selectAll");
            System.out.format("There are %d books", numOfBooks);
        }
    }
	
}
