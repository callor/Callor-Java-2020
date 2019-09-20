package com.fcryan.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fcryan.dto.MemberDTO;
import com.fcryan.mybatis.SqlMapConfig;

public class MemberDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	
	SqlSession sqlSession;
	
	private MemberDAO() {}
	
	private static MemberDAO instance = new MemberDAO();
	
	// 외부에서 getInstance()를 활용하여 1회 실시한 객체를 공유
	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	// 회원가입 = 회원등록
	public int insertMember(MemberDTO mDto) {
		int result = 0;
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.insert("insertMember", mDto);
			sqlSession.commit(); // insert, update, delete는 반드시 commit!!!
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	// 회원가입 페이지 ID중복체크(Ajax)
	public String confirmID(String userid) {
		String result = null;
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.selectOne("confirmID", userid);
			
			if(result != null) {
				result = "-1";
			} else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	// 비밀번호 수정 페이지 현재비밀번호와 일치하는지 확인
	public String confirmPW(String userid, String userpw) {
		String result = null;
		sqlSession = sqlSessionFactory.openSession();
		MemberDTO mDto = new MemberDTO();
		mDto.setId(userid);
		mDto.setPw(userpw);
		
		try {
			result = sqlSession.selectOne("confirmPW", mDto);
			if(result != null) {
				result = "-1";
			} else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	// 로그인 기능
	public MemberDTO loginCheck(String userid, String userpw) {
		sqlSession = sqlSessionFactory.openSession();
		MemberDTO mDto = new MemberDTO();
		mDto.setId(userid);
		mDto.setPw(userpw);
		try {
			mDto = sqlSession.selectOne("loginCheck", mDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return mDto;
	}
	
	// 회원정보수정(비밀번호 제외)
	public int updateMember(MemberDTO mDto) {
		int result = 0;
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.update("updateMember", mDto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	// 회원비밀번호수정(일반정보 제외)
	public int updatePw(String userid, String userpw) {
		int result = 0;
		sqlSession = sqlSessionFactory.openSession();
		MemberDTO mDto = new MemberDTO();
		mDto.setId(userid);
		mDto.setPw(userpw);
		try {
			result = sqlSession.update("updatePw", mDto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	// 회원탈퇴(삭제)
	public int deleteMember(String userid) {
		int flag = 0;
		sqlSession = sqlSessionFactory.openSession();
		try {
			flag = sqlSession.delete("deleteMember", userid);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return flag;
	}
	
	
	
// =====================================================================
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	ArrayList<MemberDTO> list = new ArrayList<>();
//	int result = 0;
//	MemberDTO mDto;
//	
//	public int insertMember(MemberDTO mDto) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "INSERT INTO member(id, pw, name, phone, email, zipcode, addr1, addr2) " + 
//					     "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, mDto.getId());
//			pstmt.setString(2, mDto.getPw());
//			pstmt.setString(3, mDto.getName());
//			pstmt.setString(4, mDto.getPhone());
//			pstmt.setString(5, mDto.getEmail());
//			pstmt.setString(6, mDto.getZipcode());
//			pstmt.setString(7, mDto.getAddr1());
//			pstmt.setString(8, mDto.getAddr2());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {  // 무조건 실행
//			DBManager.close(conn, pstmt);
//		}
//		
//		// 메서드 종료,
//		// return값(=result)을 가지고
//		// 나를 호출한 곳으로 돌아간다.
//		return result;
//	}
//	
//	// 로그인시 회원여부 체크
//	public MemberDTO loginCheck(String uid, String upw) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "SELECT * FROM member "
//					   + "WHERE id = ? AND pw = ? ";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, uid);
//			pstmt.setString(2, upw);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				String id = rs.getString("id");
//			    String pw = rs.getString("pw");
//			    String name = rs.getString("name");
//			    String phone = rs.getString("phone");
//			    String email = rs.getString("email");
//			    String zipcode = rs.getString("zipcode");
//			    String addr1 = rs.getString("addr1");
//			    String addr2 = rs.getString("addr2");
//			    Date regdate = rs.getDate("regdate");
//			    mDto = new MemberDTO(id, pw, name, phone, email, zipcode, addr1, addr2, regdate);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt, rs);
//		}
//		return mDto;
//	}
//	
//	
//	// 회원정보 수정
//	public int updateMember(MemberDTO mDto) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "UPDATE member SET "
//					   + " name = ?, "
//					   + " phone = ?, "
//					   + " email = ?, "
//					   + " zipcode = ?, "
//					   + " addr1 = ?, "
//					   + " addr2 = ? "
//					   + " WHERE id = ? ";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, mDto.getName());
//			pstmt.setString(2, mDto.getPhone());
//			pstmt.setString(3, mDto.getEmail());
//			pstmt.setString(4, mDto.getZipcode());
//			pstmt.setString(5, mDto.getAddr1());
//			pstmt.setString(6, mDto.getAddr2());
//			pstmt.setString(7, mDto.getId());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt);
//		}
//		return result;
//	}
//	
//	
//	// Ajax를 활용한 ID 중복체크
//	public int confirmID(String userid) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "SELECT id FROM member "
//					   + "WHERE id = ? ";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userid);
//			rs = pstmt.executeQuery();
//					
//			if(rs.next()) {
//				// 중복된 아이디
//				result = -1;
//			} else {
//				result = 1;
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt, rs);
//		}
//		return result;
//	}
//	
//	// Ajax를 활용한 현재 비밀번호 체크
//	public int confirmPW(String userid, String userpw) {
//		try {
//			conn = DBManager.getConnection();
//			String sql = "SELECT id FROM member "
//					   + "WHERE id = ? AND pw = ? ";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userid);
//			pstmt.setString(2, userpw);
//			rs = pstmt.executeQuery();
//					
//			if(rs.next()) {
//				// 비밀번호 일치
//				result = -1;
//			} else {
//				result = 1;
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt, rs);
//		}
//		return result;
//	}
//	
//	public int updatePw(String userId, String userPw) {
//		
//		try {
//			conn = DBManager.getConnection();
//			String sql = "UPDATE member SET "
//					   + "pw = ? "
//					   + "WHERE id = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userPw);
//			pstmt.setString(2, userId);
//			result = pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt);
//		}
//		
//		return result;
//	}
// =====================================================================
	
	
	
	
	
}






