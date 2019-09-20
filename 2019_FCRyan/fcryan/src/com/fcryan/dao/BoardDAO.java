package com.fcryan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fcryan.dto.BoardDTO;
import com.fcryan.dto.CriteriaDTO;
import com.fcryan.mybatis.SqlMapConfig;

public class BoardDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public List<BoardDTO> boardListAll(CriteriaDTO criDto) {
		sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = new ArrayList<>();
		
		try {
			list = sqlSession.selectList("boardList", criDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return list;
	}
	
	public int totalCount(CriteriaDTO criDto) {
		sqlSession = sqlSessionFactory.openSession();
		int result = 0;
		try {
			result = sqlSession.selectOne("countPaging", criDto);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	public List<BoardDTO> boardSearch(CriteriaDTO criDto) {
		sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = null;
		
		try {
			list = sqlSession.selectList("searchList", criDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	
	
	public BoardDTO boardDetailView(String bno) {
		sqlSession = sqlSessionFactory.openSession();
		BoardDTO bDto = null;
		try {
			bDto = sqlSession.selectOne("boardDetailView", bno);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return bDto;
	}
	
	
	public void viewCnt(String bno, HttpSession countSession) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			long update_time = 0;  // 10시 30분 1초
			int result = 0;
			// bno = 50 가정
			// 조회수를 증가할 때 생기는 read_time_게시글번호가 없으면
			// 현재 처음 조회수를 1증가하는 경우
			if(countSession.getAttribute("read_time_" + bno) != null) {
				update_time = (long)countSession.getAttribute("read_time_" + bno);
			}
			
			// 현재시간을 담는다
			long current_time = System.currentTimeMillis();  // 10시 30분 15초
			
			// 현재시간과 조회수 1증가한 시간을 비교해서 24시간(1일)이 지났으면
			// 조회수 1증가
			if(current_time - update_time > 24 * 60 * 60 * 1000) {
				result = sqlSession.update("viewCnt", bno);
				sqlSession.commit();
				
				// 조회수 1증가한 시간을 session에 담는다.
				countSession.setAttribute("read_time_" + bno, current_time);
				
				// session 저장소
				// read_time_50이라는 방을 하나 만들고
				// 현재시간을 저장(10시 30분 5초)
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public int boardInsert(BoardDTO bDto) {
		// boolean값을 true로 주면 AutoCommit 설정!
		sqlSession = sqlSessionFactory.openSession(true);
		int result = 0;
		try {
			result = sqlSession.insert("boardInsert", bDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	public void boardUpdate(BoardDTO bDto) {
		sqlSession = sqlSessionFactory.openSession();
		int result = 0;
		try {
			result = sqlSession.update("boardUpdate", bDto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void boardDelete(String bno) {
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.delete("boardDelete", bno);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void boardReplyCntPlus(int bno) {
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.update("ReplyCntPlus", bno);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	
	public void boardReplyCntMinus(String bno) {
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.update("ReplyCntMinus", bno);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	
	
}
