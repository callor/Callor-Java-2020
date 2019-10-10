package com.callor.pay.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.callor.pay.domain.PaperVO;

/*
 * PayReadService에서 pay.txt 파일을 읽은 정보를 가져오고
 * => payStrList
 * 읽은정보(리스트)를 한사람분의 급여를 
 * 각각 PaperMakeService에 주입을하고
 * 화폐매수를 계산한 결과를 가져와서
 * console에 보여줄것
 */
public class PaperPrintServiceV1 {
	
	PayReadServiceV1 pr;
	PaperMakeServiceV1 pm;
	List<List<PaperVO>> paperAllList;
	

	// Ex클래스에서 파일 이름을 주입할때 받을 변수
	String payFile ;
	
	public PaperPrintServiceV1() {
		pr = new PayReadServiceV1();
		pm = new PaperMakeServiceV1();
	}
	
	// PaperPrintServiceV1 pp = new PaperPrintServiceV1("pay.txt");
	public PaperPrintServiceV1(String payFile) {
	
		// 기본생성자를 호출해서
		// pr 객체와 pm 객체를 생성하고 인스터는 만들어 둔다.
		this(); // 기본생성자를 호출하라  
		this.payFile = payFile;
	
	}
	
	// pp.setPayFile("pay.txt")
	public void setPayFile(String payFile) {
		this.payFile = payFile;
	}

	public void printPaper() throws IOException {

		String payPath = "src/com/biz/pay/";
		
		for(List<PaperVO> paperList : this.paperAllList) {

			PrintWriter fileOut 
			= new PrintWriter(payPath + paperList.get(0).getMember()); 
			
			fileOut.println("=========================================");
			fileOut.print("사원번호: " + paperList.get(0).getMember()  );
			fileOut.println(", 급여액 : " + paperList.get(1).getMember());
			fileOut.println("----------------------------------------");
			
			for(PaperVO pVO : paperList) {
				fileOut.printf("%s\t%d\n",pVO.getPaper(),pVO.getCount());
			}
			fileOut.close();
		}
	}
	
	public void viewPaper() throws IOException {
		for(List<PaperVO> paperList : this.paperAllList) {

			System.out.println("=========================================");
			System.out.print("사원번호: " + paperList.get(0).getMember()  );
			System.out.println(", 급여액 : " + paperList.get(1).getMember());
			System.out.println("----------------------------------------");

			for(PaperVO pVO : paperList) {
				System.out.printf("%s\t%d\n",pVO.getPaper(),pVO.getCount());
			}
		}
		
	}
	
	public void makePaperList() throws IOException {
		
		// pay.txt 파일을 읽어서
		// payStrList로 생성하는 과정
		pr.readPay(this.payFile);
		List<String> payStrList = pr.getPayStrList();
		paperAllList = new ArrayList<List<PaperVO>>();
		
		// payStrList는 문자열(String)을 담고 있는 
		//	List 형이기 때문에
		// for 반복문을 이용해서 한개씩 추출이 된다.
		for(String pay : payStrList) {
			// pay 사번:급여 형식의 문자열이 들어 있다.
			// pay를 사번, 급여 부분으로 분해
			String[] pays = pay.split(":");
			// pays[0] 사번
			// pays[1] 급여액
			
			// 문자열로 된 급여액을 정수형으로 변환
			int intPay = Integer.valueOf(pays[1]);
			
			// 급여액을 pm 클래스에 주입을 해서 화폐매수를 계산
			pm.make(intPay);
			List<PaperVO> paperList = pm.getPaperList();
			paperList.get(0).setMember(pays[0]);
			paperList.get(1).setMember(pays[1]);

			// paperList 리스트를 paperAllList에 추가
			paperAllList.add(paperList);

		}
	}
	
}
