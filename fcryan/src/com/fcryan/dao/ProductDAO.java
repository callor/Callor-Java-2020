package com.fcryan.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fcryan.dto.ProductDTO;
import com.fcryan.mybatis.SqlMapConfig;


public class ProductDAO {

	// MyBatis 셋팅값 호출
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	
	// mapper에 접근하기 위한 SqlSession
	SqlSession sqlSession;
	
	// 싱글톤으로 new 없이 사용하기 때문에
	// 다른곳에 new로 객체생성 못하게 private으로 막음
	private ProductDAO() {}
	
	// 싱글톤 패턴 - 객체생성 1회 실시 후 공유해서 사용
	// 객체생성 1회 실시
	private static ProductDAO instance = new ProductDAO();
	
	// 외부에서 getInstance()를 활용하여 1회 실시한 객체를 공유
	public static ProductDAO getInstance() {
		return instance;
	}
	
	// 실제 동작들...
	// Best 상품목록 출력(Index 페이지)
	public List<ProductDTO> bestView() {
		sqlSession = sqlSessionFactory.openSession();
		List<ProductDTO> bestList = null;
		try {
			bestList = sqlSession.selectList("bestView");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return bestList;
	}
	
	// New 상품목록 출력(Index 페이지)
	public List<ProductDTO> newView() {
		sqlSession = sqlSessionFactory.openSession();
		List<ProductDTO> newList = null;
		try {
			newList = sqlSession.selectList("newView");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return newList;
	}
	
	// 각 club 팀 출력
	public List<ProductDTO> clubView(String code) {
		sqlSession = sqlSessionFactory.openSession();
		List<ProductDTO> clubList = null;
		try {
			HashMap<String, String> map = new HashMap<>();
			map.put("code", code);
			clubList = sqlSession.selectList("clubView", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return clubList;
	}
	
// =====================================================================
//  Mybtis 사용하기 전 DBManager와 
//	PrepareStatemnet 방식으로 구현한 DAO 객체
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	int result = 0;
//	
//	public ArrayList<ProductDTO> bestView() {
//		ArrayList<ProductDTO> list = new ArrayList<>();
//		try {
//			conn = DBManager.getConnection();
//			String sql = "SELECT * FROM best_pro_view ";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				String p_code = rs.getString("p_code");
//				String p_name = rs.getString("p_name");
//				String p_statidum = rs.getString("p_statidum");
//				String p_local = rs.getString("p_local");
//				int p_price = rs.getInt("p_price");
//				String p_img = rs.getString("p_img");
//				Date p_indate = rs.getDate("p_indate");
//				ProductDTO pDto = new ProductDTO(p_code, p_name, p_statidum, p_local, p_price, p_img, p_indate);
//				list.add(pDto);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt, rs);
//		}
//		
//		return list;
//	}
//	
//	public ArrayList<ProductDTO> newView() {
//		ArrayList<ProductDTO> list = new ArrayList<>();
//		try {
//			conn = DBManager.getConnection();
//			String sql = "SELECT * FROM new_pro_view ";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				String p_code = rs.getString("p_code");
//				String p_name = rs.getString("p_name");
//				String p_statidum = rs.getString("p_statidum");
//				String p_local = rs.getString("p_local");
//				int p_price = rs.getInt("p_price");
//				String p_img = rs.getString("p_img");
//				Date p_indate = rs.getDate("p_indate");
//				ProductDTO pDto = new ProductDTO(p_code, p_name, p_statidum, p_local, p_price, p_img, p_indate);
//				list.add(pDto);
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt, rs);
//		}
//		
//		return list;
//	}
	// =====================================================================	
	
	
	
	
	
	
	
	
	
}
