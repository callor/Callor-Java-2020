package com.callor.dbms.service;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.dbms.config.DBConnection;
import com.callor.dbms.dao.BBsDao;
import com.callor.dbms.persistence.BBsDTO;

public class BBsServiceV2 extends BBsServiceV1{
	
	private SqlSession sqlSession = null;
	private BBsDao bbsDao = null;
	
	protected Scanner scanner = null ;

	public BBsServiceV2() {
			
		scanner = new Scanner(System.in);
		
		/**
		 * sqlSession을 DBConnection으로 부터 받아오기
		 */
		sqlSession = DBConnection
						.getSqlSessionFactory()
						.openSession(true);

		/**
		 * sqlSession으로 부터 Mapper 받아오기
		 */
		bbsDao = sqlSession
				.getMapper(BBsDao.class);
	
	
	}
	
	public void bbsMenu() {
		while(true) {
			System.out.print("내용보기(SQ입력)  W.작성  U.수정  D.삭제  Q.종료 >>");
			String strMenu = scanner.nextLine();
			if(strMenu.equalsIgnoreCase("Q")) {
				return ;
			} else if(strMenu.equalsIgnoreCase("W")) {
				
				this.writeBBS();
				this.viewBBsList();
				
			} else if(strMenu.equalsIgnoreCase("U")) {
			} else if(strMenu.equalsIgnoreCase("D")) {
			} else {
				try {
					long longSEQ = Integer.valueOf(strMenu);
					this.viewText(longSEQ);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	public void viewText(long bs_id) {
		
		BBsDTO bbsDTO = bbsDao.findById(bs_id);
		
		if(bbsDTO == null) {
			System.out.println("내용이 없습니다");
		} else {
			System.out.println("======================================");
			System.out.println("제목 : " + bbsDTO.getBs_subject());
			System.out.println("작성 : " + bbsDTO.getBs_writer());
			System.out.println("작성일 : " + bbsDTO.getBs_date());
			System.out.println("작성시각 : " + bbsDTO.getBs_time());
			System.out.println("--------------------------------------");
			System.out.println(bbsDTO.getBs_text());
			System.out.println("======================================");
		}
		
		
	}
	


}
