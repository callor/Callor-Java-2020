package com.callor.bank.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.callor.bank.domain.BankBookVO;
import com.callor.bank.util.BankInfo;

public class BankServiceImpV1 implements BankService {

	// TODO 계좌번호, 계좌정보VO 가 저장될 list
	Map<String,BankBookVO> bankBookList = null ; 
	BankBookVO bookVO = null;
	
	// TODO 키보드 장치 선언
	Scanner scanner = null;
	
	String bookFile;
	
	// TODO 생성자 method
	public BankServiceImpV1() {
		// TreeMap : key값을 중심으로 오름차순 자동정렬
		bankBookList = new TreeMap<String,BankBookVO>();
		
		// TODO 키보드 연결
		scanner = new Scanner(System.in);
	}
	
	@Override
	public void readBook(String bookFile) throws Exception {
	
		// TODO키워드는 주석문내에서 사용되는 Keyword로
		//	소스코드를 쉽게 찾아갈수 있는 book mark를 설정한다
		
		this.bookFile = bookFile;
		
		// TODO 잔고원장 파일을 읽어서 리스트로 생성
		FileReader fileReader;
		BufferedReader buffer;
		
		fileReader = new FileReader(bookFile);
		buffer = new BufferedReader(fileReader);
		
		String reader = new String();
		while(true) {
			reader = buffer.readLine();
			if(reader == null) break;
			
			// 파일에서 한줄을 읽어 reader 에 저장된 문자열을
			// 분해(분리)하여 계좌정보를 생성
			String[] books = reader.split(":");
			/*
			 * books[0] : 계좌정보
			 * books[1] : 최종잔액
			 * books[2] : 최종거래일자
			 * books[3] : 구분
			 */
			String strNum = books[BankInfo.BOOK.NUM]; // books[0]
			String strBalance = books[BankInfo.BOOK.BALANCE]; // books[1]
			String strLastDate = books[BankInfo.BOOK.LAST_DATE];// books[2]
			String strRemark = books[BankInfo.BOOK.REMARK];// books[3]

			int intBalance = Integer.valueOf(strBalance);

			// reader 에서 각 항목별로 분리한 값을 BankBookVO에 담기
			BankBookVO bookVO = new BankBookVO();
			bookVO.setNum(strNum);
			bookVO.setBalance(intBalance);
			bookVO.setLastDate(strLastDate);
			bookVO.setRemark(strRemark);
			
			// 리스트에 추가
			bankBookList.put(strNum, bookVO);
			
			// Debugging code
			// bookVO에 값이 제대로 담겼나를 확인하는 코드
			System.out.println(bookVO.toString());
			
		} // end while
		buffer.close();
		fileReader.close();
	}

	/*
	 * 키보드로 계좌번호를 입력받아서
	 * 계좌번호가 list에 있으면
	 * 계좌정보(VO)를 추출하여 임시 보관하기
	 */
	@Override
	public void viewAcc() {
		// TODO 계좌정보조회
		System.out.print("계좌번호>> ");
		String strNum = scanner.nextLine();
		
		// bankBookList에서 strNum 키값을 조회하고
		// 그 결과를 BankBookVO에 담기
		// BankBookVO bookVO = bankBookList.get(strNum);
		
		// bankBookList에서 추출된 bookVO를 입,출금 처리 method에서
		// 사용할 수 있도록 맴버변수 영역으로 이동하기
		bookVO = bankBookList.get(strNum);
		
		// bookVO에는 계좌정보나 null 값이 담기게 된다.
		// 계좌정보가 담기는 경우 ? : strNum 계좌가 list에 있을때
		// null 이 담기는 경우 ? : strNum 계좌가 list에 없을때
		if(bookVO == null) {
			System.out.println("계좌정보가 없음");
		}
	}

	@Override
	public void input() throws Exception{

		// TODO 입금처리
		this.viewAcc(); // 계좌조회
		
		// 앞에서 조회한 계좌정보가 유효한지 검사
		// viewAcc() 에서 유효하지 않은 계좌정보에 대해서는
		// 이미 메시지를 보여 주었으므로
		// 여기에서는 검사만 하고, 더이상 진행을 멈추어버리자.
		if(bookVO == null) return;
		
		System.out.print("입금액 >> ");
		String strInput = scanner.nextLine();
		int intInput = Integer.valueOf(strInput);
		
		// 만약 입금액이 (-) 이면 입금 거부!!
		if(intInput < 0) {
			System.out.println("입금액은 0원 이상이어야 함!!");
			return;
		}
		int intBalance = bookVO.getBalance();
		intBalance +=  intInput;
		bookVO.setBalance(intBalance);
		
		// 거래일자, 구분 값 추가
		Date date = new Date(); // 현재 날짜 가져오기
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String lastDate = sd.format(date);
		bookVO.setLastDate(lastDate);
		bookVO.setRemark(BankInfo.REMARK.INPUT);
		
		// 입금처리된 내역을 통장파일에 저정하기
		// 구분문자열과 입금된 금액을 파라메터로 전달
		this.accListWrite(BankInfo.REMARK.INPUT, intInput);
		
		// 입금처리가 완료된 후
		// 원장에 내용을 저장하는 bookWriter() method를 호출한다.
		// 여기서 하나의 문제가 발생하는데
		// 저장할 파일이름을 넘겨줄 방법을 모색해야 한다.
		// input() method를 변경하여
		// input(String bookFile) 형식으로 바꿀수도 있지만,
		// 그렇게 하면
		// interface, 그리고 interface를 implement 한 클래스
		// 모두를 변경해야하는 대 공사가 필요하다.
		
		// 최소한의 코드를 변경하여
		// 원하는 결과를 얻기 위해서
		// Service 클래스에서 bookFile 맴버변수(필드)를 하나
		// 선언하고,
		// readBook() method에서 bookFile 변수 값을 setting하여
		// 값을 공유하도록 설정한다.
		this.bookWrite(bookFile);
		
	}

	/*
	 * 1. 앞에서 조회된 계좌번호가 유효하지 않으면 method 종료
	 * 		bookVO가 null 이면 계좌번호가 유효하지 않다.
	 * 2. 키보드로 출금액을 입력받고
	 * 3. 음수이면 출금 거부!!
	 * 		입력받은 값 < 0 이면 거부
	 * 4. 잔액 >= 출금 이면 출금 처리
	 * 5. 	아니면 출금 거부
	 */
	@Override
	public void output() throws Exception{
		// TODO 출금처리
		this.viewAcc();
		
		if(bookVO != null) {
			System.out.print("출금액>> ");
			String strOutput = scanner.nextLine();
			
			int intOutput = Integer.valueOf(strOutput);
			if(intOutput > 0) {
				int intBalance = bookVO.getBalance();
				if(intBalance >= intOutput) {
					intBalance -= intOutput;
					bookVO.setBalance(intBalance);
					
					LocalDate ld = LocalDate.now();
					DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String lastDate = df.format(ld);
					bookVO.setLastDate(lastDate);
					bookVO.setRemark(BankInfo.REMARK.OUTPUT);

					this.accListWrite(BankInfo.REMARK.OUTPUT, intOutput);
					
					this.bookWrite(bookFile);
				} else {
					System.out.println("잔액부족 출금거부!!");
				}
			} else {
				System.out.println("출금액은 0 이상이어 함!!");
			}
		}
	}

	/*
	 * 입,출금이 완료되는 순간 bookFile에
	 * 변동 내역 저장
	 * 
	 * booFile 변수를 매개변수로 받아
	 * 변수값을 파일명으로 하는 처리를 수행해야 한다.
	 */
	@Override
	public void bookWrite(String bookFile) throws Exception {
		// TODO 원장정보 파일에 저장

		PrintWriter fileOut ;
		fileOut = new PrintWriter(bookFile);
		Set<String> keys = bankBookList.keySet();
		for(String s : keys) {
			fileOut.printf("%s:%d:%s:%s\n",
					bankBookList.get(s).getNum(),
					bankBookList.get(s).getBalance(),
					bankBookList.get(s).getLastDate(),
					bankBookList.get(s).getRemark()
					);
			fileOut.flush();
		}
		fileOut.close();
	
	}

	/*
	 * 어떤 계좌에서 입금이나 출금이 발생을 하면
	 * 내역을 "계좌번호파일" 에 저장을 한다.
	 */
	@Override
	public void accListWrite(String remark, int money) throws Exception {
		// TODO 거래내역 파일로 저장
		
		String strAccPath = "src/com/callor/bank/books/";
		FileWriter fileWriter;
		PrintWriter accBook;
		
		// 계좌번호로 거래내역을 저장할 파일이름을 생성
		// BOOK-0001
		String accBookFile = String.format("BOOK-%s.txt",bookVO.getNum());
		
		// FileWriter(,true) 
		// 	파일이 이미 있으면 append(추가) mode로 open하고
		//  그렇지 않으면(파일이 없으면) 생성하라
		// 	파일 생성 : src/com/biz/bank/acc/BOOK-0001.txt
		fileWriter = new FileWriter(strAccPath + accBookFile,true);
		accBook = new PrintWriter(fileWriter);

		int intBalance = bookVO.getBalance();
		String lastDate = bookVO.getLastDate();
		
		int intInput = 0;
		int intOutput = 0;
		
		intInput = money;
		if(remark.equals(BankInfo.REMARK.OUTPUT)) {
			intInput = 0;
			intOutput = money ;
		}
		// 거래일자, 구분, 입금, 출금, 현잔액
		String strWriter = String.format("%s:%s:%d:%d:%d",
				lastDate,remark,intInput,intOutput,intBalance);
		accBook.println(strWriter);
		
		accBook.flush();
		accBook.close();
		fileWriter.close();
	
	}
}
