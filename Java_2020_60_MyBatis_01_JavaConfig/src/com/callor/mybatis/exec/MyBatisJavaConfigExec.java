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
import com.callor.mybatis.mapper.MapperDao;

public class MyBatisJavaConfigExec {

	private static SqlSessionFactory sesFact = null;

    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        prop.setProperty("driver", "com.mysql.jdbc.Driver");
        prop.setProperty("url", "jdbc:mysql://localhost:3306/testdb");
        prop.setProperty("user", "testuser");
        prop.setProperty("password", "test623");

        DataSourceFactory mdsf = new DataSourceFactoryImpl();
        mdsf.setProperties(prop);
        DataSource ds = mdsf.getDataSource();

        TransactionFactory trFact = new JdbcTransactionFactory();
        Environment environment = new Environment("development", trFact, ds);
        Configuration config = new Configuration(environment);
        config.addMapper(MapperDao.class);

        sesFact = new SqlSessionFactoryBuilder().build(config);

        try (SqlSession session = sesFact.openSession()) {

            int numOfBooks = session.selectOne("getNumberOfBooks");
            System.out.format("There are %d books", numOfBooks);
        }
    }
	
}
