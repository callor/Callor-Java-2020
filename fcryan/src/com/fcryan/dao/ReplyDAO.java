package com.fcryan.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fcryan.dto.ReplyDTO;
import com.fcryan.mybatis.SqlMapConfig;

public class ReplyDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	private ReplyDAO() {}
	private static ReplyDAO instance = new ReplyDAO();
	
	public static ReplyDAO getInstance() {
		return instance;
	}
	
	public List<ReplyDTO> replyListAll(String bno){
		List<ReplyDTO> list = null;
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("replyListAll", bno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	public int replyInsert(ReplyDTO rDto) {
		int result = 0;
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.insert("replyInsert", rDto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	public void replyDeleteAll(String bno) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete("replyDeleteAll", bno);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void replyDelete(String rno) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete("replyDelete", rno);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	
	
	
	
}








