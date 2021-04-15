package com.callor.score.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;
import com.callor.score.model.StudentVO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;
import com.callor.std.InputService;
import com.callor.std.impl.InputServiceImplV1;

public class ScoreServiceImplV1  implements ScoreService {

	protected InputService inService;
	protected StudentService stService;
	protected List<ScoreVO> scoreList;
	protected Scanner scan;
	protected String scoreFileName; 
	
	
	protected final int 학번 = 0 ;
	protected final int 국어 = 1 ;
	protected final int 영어 = 2 ;
	protected final int 수학 = 3 ;
	
	public ScoreServiceImplV1() throws IOException {
		this("src/com/callor/score/score.txt");
	}
	public ScoreServiceImplV1(String scoreFileName) throws IOException {
		this.scoreFileName = scoreFileName;
		inService = new InputServiceImplV1();
		stService = new StudentServiceImplV1();
		scoreList = new ArrayList<ScoreVO>();
		scan = new Scanner(System.in);
		
		this.loadScore();
	}
	
	/*
	 * 
	 * 학번입력하면
	 * scoreList에 같은 학번의 성적이 있는지 확인하여
	 * 있으면 저장이 안되게
	 * 이미 있으면 다시 학번을 입력하도록 해야 한다
	 * 
	 */
	@Override
	public void insertScore() {
		// TODO 성적입력

		// 유효성검사가 끝난 후 학번을 가지고
		// VO에 담아야 하기 때문에 while() 전에 선언
		String strNum = null;
		while(true) {
			Integer intNum = inService.inputValue("학번",1);
			if(intNum == null) {
				return;
			}
			// 00001 형식으로 학번 변환(생성)
			strNum = String.format("%05d",intNum);
			
			// 이미 등록된 학번인가를 검사
			ScoreVO scoreVO = this.numCheck(strNum);
			if(scoreVO != null) {
				continue;
			}
			// 여기에 도달하면 
			//		학번에 해당하는 점수가 list에 없다!!
			// 학생정보에 등록된 학번인가를 검사하여
			//		학생정보에 없으면 다시 학번을 입력받고
			//		있으면 점수를 입력하도록 break;
			StudentVO stVO = stService.getStudent(strNum);
			if(stVO == null) {
				System.out.println("학적부에 없는 학생입니다!!");
				System.out.println("학번을 다시 입력해 주세요");
				continue;
			}
			
			// 여기 도달하면 학적부에 있는 학번이다
			System.out.println("=".repeat(30));
			System.out.printf("학번:%s\n", stVO.getNum());
			System.out.printf("이름:%s\n", stVO.getName());
			System.out.printf("학과:%s\n", stVO.getDept());
			System.out.printf("학년:%s\n", stVO.getGrade());
			System.out.printf("주소:%s\n", stVO.getAddress());
			System.out.println("=".repeat(30));
			System.out.println("학생정보가 맞습니까 ?");
			System.out.println("맞으면 : Enter, 틀리면 : NO");
			System.out.print(">> ");
			String yesNo = scan.nextLine();
			if( yesNo.equals("NO") ) {
				continue;
			}
			break;
		} // 학번입력 끝

		// 성적입력 부분...
		Integer intKor = null;
		intKor = inService.inputValue("국어", 0, 100);
		if(intKor == null) {
			return;
		}

		Integer intEng = null;
		intEng = inService.inputValue("영어", 0, 100);
		if(intEng == null) {
			return;
		}

		Integer intMath = null;
		intMath = inService.inputValue("수학", 0, 100);
		if(intMath == null) {
			return;
		}
		
		// 위에서 담겨있던 데이터는 clear되고
		// 새로운 scoreVO가 생성된다
		ScoreVO scoreVO = new ScoreVO();
		scoreVO.setNum(strNum);
		scoreVO.setKor(intEng);
		scoreVO.setKor(intMath);
		scoreVO.setKor(intKor);
		scoreList.add(scoreVO);

	} // end insertScore()
	
	// 파라메터로 전달받은 학번이 scoreList에 있는지 검사
	// 있으면 scoerVO를 return
	// 없으면 null을 return
	protected ScoreVO numCheck(String num) {
		for(ScoreVO vo : scoreList) {
			if(vo.getNum().equals(num)) {
				return vo;
			}
		}
		return null;
	}

	@Override
	public void loadScore() throws FileNotFoundException, IOException {
		// TODO 파일을 읽어 성적 데이터 만들기
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		fileReader = new FileReader(this.scoreFileName);
		buffer = new BufferedReader(fileReader);
		
		String reader ;
		while((reader = buffer.readLine()) != null) {
			String scores[] = reader.split(":");
			ScoreVO scoreVO = new ScoreVO();
			scoreVO.setNum(scores[학번]);
			scoreVO.setKor(Integer.valueOf(scores[국어]));
			scoreVO.setEng(Integer.valueOf(scores[영어]));
			scoreVO.setMath(Integer.valueOf(scores[수학]));
			
			scoreList.add(scoreVO);
		}
		buffer.close();
	}

	@Override
	public void printScore() {
		// TODO 학생성적리스트
		System.out.println("=".repeat(100)+"\n");
		System.out.println("빛나라 고등학교 성적처리 프로젝트 V2\n" );
		System.out.println("=".repeat(100));
		System.out.println("학번\t이름\t학과\t\t 학년\t 국어\t 영어\t 수학\t 총점\t 평균");
		System.out.println("-".repeat(100));
		
		for(ScoreVO vo : scoreList) {
			StudentVO stVO = stService.getStudent(vo.getNum());
			System.out.print(vo.getNum() + "\t");
			System.out.print(stVO.getName() + "\t");
			System.out.printf("%-10s\t",stVO.getDept());
			System.out.printf("%5s\t",stVO.getGrade());
			System.out.printf("%5d\t",vo.getKor());
			System.out.printf("%5d\t",vo.getEng());
			System.out.printf("%5d\t",vo.getMath());
			System.out.printf("%5d\t",vo.getTotal());
			System.out.printf("%3.2f\n",vo.getAvg());
		}
		System.out.println("=".repeat(100));
	}
}
