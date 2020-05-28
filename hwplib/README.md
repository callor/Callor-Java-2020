
# hwplib

한글과 컴퓨터(한컴)에서 만든 워드프로세서 "한글"의 파일에 대한 라이브러리입니다.

이 라이브러리는 개발자의 순수한 재능 기부 차원에서 개발하고 있습니다. 맘 편하니 받아서 사용하시면 됩니다. 
 
* 사용한 라이브러리나 문서 
	- Apache-POI 라이브러리 - 한글 파일의 하부 구조인 Microsoft Compound File의 부분의 파싱.
	- 한글과컴퓨터에서 공개한  '한글 문서 파일 구조 5.0' 문서 ( http://www.hancom.com/etc/hwpDownload.do?gnb0=269&gnb1=271&gnb0=101&gnb1=140 )

* 이 라이브러리에서 할 수 있는 일.(kr.dogfoot.hwplib.test 패키지 참조)
	- 한글 파일을 읽어서 객체로 생성 (TestReadingHWPFile 참고)
	- 만들어진 객체를 파일로 저장 (TestReWritingHWPFile 참고)
	- 한글 파일에서 텍스트 추출(TestExtractingText 참고)
	- 특정 필드의 텍스트 추출  (TestGettingClickHereFieldText 참고)
	- 특정 필드의 텍스트 설정 (TestSetClickHereFieldText 참고)
	- 조건에 맞는 컨트롤 찾기 (TestFindControl 참고)
	- 다른 파일의 내용(문단)을 추가하기 (TestParagraphAdder 참고)
	- 표의 셀 병합하기 (TestMergingCell 참고)
	- 기타  설정 : 페이지 크기 변경 (TestChangePaperSize 참고), 이미지 주가(TestInsertImage 참고), 폰트 크기, 밑줄 등의  글자모양 설정(TestMakingCharShape 참고), 표 컨트롤 생성 (TestMakingTable 참고)...

* 이 라이브러리는 이미지 파일, PDF 파일, HTML 파일로 변환 기능은 아직 지원하지 않습니다. (문의가 많이 들어옴)

2019.01.28
=========================================================================================
* FieldFiner에 이름이 같은 필드 모두 찾는 함수 추가...  - jclab 님 요청
* test/TestFindAllField.java 참고


2018.11.20
=========================================================================================
* IDMapping의 문단 모양 개수와 저장된 실제 문단 모양 개수가 다를 때 보정..   - boojongmin@gmail.com 님 요청  


2018.10.17
=========================================================================================
* 필드 설정 기능 강화 :멀티라인 텍스트, 이름이 동일한 필드를 위한 값 리스트, 누름틀 필드 이외에 필드 설정... - jhlee@futechsoft.com 님 요청
* test/TestSetField.java 참고


2018.09.14
=========================================================================================
* 표 셀 병합하기 - codeless73 님 요청
* test/TestMergingCell.java 참고


2018.08.31
=========================================================================================
* 필드 텍스트 설정 기능 추가 - jhlee@futechsoft.com 님 요청
* test/TestSetClickHereFieldText.java 참고


2018.08.21
=========================================================================================
* 저장 때 이미지 압축과정에서 오류 수정 - urusaikara@gmail.com 님 요청


2018.08.17
=========================================================================================
* 다른 한글 파일에서 있는 문단 추가하는 기능 추가 - accforaus 님 요청
* 문단에 포함된 글자만 추가됨. 문단에 포함된 컨트롤들과 메모들을 추가하는 부분은 아직 구현 못함(추후 추가 예정임) 
* test/TestParagraphAdder.java 참고


2018.07.18
=========================================================================================
* 5.0.2.5의 각주 컨트롤 읽을 때 오류 나는 문제 수정  - accforaus 님 요청
* BinData가 스토리지 디폴트 모드로 압축되었을 떄 오류 나는 문제 수정


2018.07.10
=========================================================================================
* 문단의 글자모양(글꼴, 크기, Bold/Italic, 글자색 등) 설정하는 샘플 추가 - zuoliang0 님 요청
* test/TestMakingCharShape.java 참고


2018.05.04 
=========================================================================================
* 이미지 컨트롤 동적 생성 샘플 추가 - parkmap@gmail.com 님 요청
* test/TestInsertImage.java 참고


2018.03.20
=========================================================================================
* 표 동적 생성 샘플 추가 - krPlatypus 님 요청
* test/TestMakingTable.java 참고


2017.11.23
=========================================================================================
* 압축 푸는 방식 개선 등의 오류 수정 및 객체 연결선 컨트롤 추가 - osc91 님 요청


2017.11.14
=========================================================================================
* 메모 있는 문서가 읽히지 않는 오류 수정 - osc91 님 요청


2017.8.31
=========================================================================================
* 컨트롤 찾기 기능 추가 - osc91 님 요청
	- TestFindObject.java 참조
```java
    	public static class MyControlFilter implements ControlFilter {
    		public boolean isMatched(Control control, Paragraph paragrpah, Section section) {
	   		// 필터링 조건 입력 
		}
    	}
	
	ArrayList<Control> result = ControlFinder.find(hwpFile, new MyControlFilter());
```


2017.8.21
=========================================================================================
* URL로 부터 읽는 기능 추가 - osc91 님 요청

```java
	String url = "http://ocwork.haansoft.com/sample/sample.hwp";
	HWPFile hwpFile = HWPReader.fromURL(url); 
```


2017.6.1
=========================================================================================
* 저장 모듈 완료
	- TestEditingHWPFile.java, TestReWritingHWPFile.java 참고
```java
	// 파일을 열어서
	String filename = "sample_hwp\\test-blank.hwp"; 
	HWPFile hwpFile = HWPReader.fromFile(filename); 
	
	if (hwpFile != null) {
	
	    // 첫번째 구역/문단에 문자열 추가하고
		Section s = hwpFile.getBodyText().getSectionList().get(0);
		Paragraph firstParagraph = s.getParagraph(0);
		firstParagraph.getText().addString("이것은 추가된 문자열입니다.");

		// 다른 이름으로 저장
		String writePath = filename.substring(0, 11) + "ed-" + filename.substring(11);
		HWPWriter.toFile(hwpFile, writePath);
	}
```


2017.4.26
=========================================================================================
* 구버전에서 만든 파일 읽기 오류 수정 - quantum123님 요청
	- 5.0.0.6, 5.0.2.4.1, 5.0.0.3, 5.0.1.6, 5.0.3.0.1, 5.0.0.5, 5.0.1.7 버전


2017.4.14
=========================================================================================
* 한 장 이상의 긴 문단을 읽지 못하는 문제 해결


2017.4.4
=========================================================================================
* 누름틀 필드 텍스트 찾기 기능 
	- 필드 텍스트가 여러 줄일때 처리 
	- 필드 텍스트에 컨트롤이 포함되었을 경우 처리
	- FieldFinder.getClickHereText() 에서 필드 텍스트에 컨트롤이 포함되었을 경우 처리를 위해 TextExtractMethod temInField 매개변수를 추가하였습니다.
```java
	String text1 = FieldFinder.getClickHereText(hwpFile, "필드1", TextExtractMethod.OnlyMainParagraph);
```


2017.3.29
=========================================================================================
* 누름틀 필드 텍스트 찾기 기능 완료 - musasin84님 요청
	- test/TestGettingClickHereFieldText.java 파일 참고 
```java
	HWPFile hwpFile = HWPReader.fromFile(filename);
	String text1 = FieldFinder.getClickHereText(hwpFile, "필드이름");
```


2017.3.20
=========================================================================================
* 누름틀 필드 컨트롤 읽기 오류 수정


2017.1.6
=========================================================================================
* 텍스트 추출기 모듈을 추가하였습니다. 
 	- TextExtractor.extract()의 두번째 파라미터 값에 따라 세가지 추출 방법을 구현했습니다.
		- OnlyMainParagraph // 메인 문단에 포함된 텍스트만 추출함
		- InsertControlTextBetweenParagraphText // 컨트롤의 텍스트를 문단 텍스트 사이에 삽입하여 추출함
		- AppendControlTextAfterParagraphText // 컨트롤의 텍스트를 문단 텍스트 뒤에 추가하여 추출함
	- test/TestExtractingText.java 파일 참고 <br> 
```java
	HWPFile hwpFile = HWPReader.fromFile(filename); 
	String hwpText = TextExtractor.extract(hwpFile, TextExtractMethod.InsertControlTextBetweenParagraphText);
```
* 읽기 모듈에서 버그 수정하였습니다.
* 소스 인코딩을 euc-kr에서 utf-8로 변경하였습니다. 


2016.12.23 
=========================================================================================
* 이 번 배포버전은 읽기 모듈 까지만 구현되었습니다. 쓰기 모듈은 추후 상황을 봐서 구현할 계획입니다.
	- 각각의 객체들과 객체에 포함된 메소스들에 대해선 "/doc" 디렉토리에 있는 javadoc 문서를 참고하시기 바랍니다.
```java
	// 파일을 읽는다. 
	HWPFile hwpFile = HWPReader.fromFile(filename);  			
	
	// 파일에서 첫번째 구역을 얻는다. 
	Section s = hwpFile.getBodyText().getSectionList().get(0); 		
	
	// 첫번째 구역에서 첫번째 문단을 얻는다. 
	Paragraph p = s.getParagraphList().get(0);				
	...		
```
