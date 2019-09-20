package com.fcryan.dto;

public class PageMakerDTO {
	private int totalCount; // 284         // 전체 데이터 개수
	private int startPage;  //1           // 시작 페이지 번호
	private int endPage;    // 2         // 끝 페이지 번호
	private boolean prev;  // false            // 이전 페이지
	private boolean next;  // true             // 이후 페이지
	private int displayPageNum = 10; // 화면에 보여지는 블럭 수
	private int finalPage;   // 29
	
	private CriteriaDTO criDto;  // page(1), pagestart(1), perPageNum(10)
//	private int page; // 2       // 페이지 번호(하단의 번호들 클릭)
//	private int perPageNum; // 20  // 한 페이지에 보여줄 게시글 수
//	private String keyword; // null // 검색 키워드
//	private String flag;    // null // 검색 타입
//	private String code;    // new // 
	
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}
	
	private void calcData() {
		// Math 클래스의 ceil 메서드는 무조건 소수점을 올림함 0.2 = 1로 처리
		endPage = (int)Math.ceil(criDto.getPage() / (double)displayPageNum) * displayPageNum;
		//  10                           2  /  10 = 0.2 => 1  * 10   
		startPage = (endPage - displayPageNum) + 1;
		// 1
		int tempEndPage = (int)(Math.ceil(totalCount / (double)(criDto.getPerPageNum() / criDto.getPage())));
		//  29                              284 / (20 / 2)
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;      
		next = (endPage * (criDto.getPerPageNum()/criDto.getPage())) >= totalCount ? false : true;
		
		finalPage = (int)Math.ceil(totalCount / (double)(displayPageNum)); 
	}
	
	
	
	
	
	

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public CriteriaDTO getCriDto() {
		return criDto;
	}

	public void setCriDto(CriteriaDTO criDto) {
		this.criDto = criDto;
	}
	
	public int getFinalPage() {
		return finalPage;
	}

	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
	}

	@Override
	public String toString() {
		return "PageMakerDTO [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", finalPage="
				+ finalPage + ", criDto=" + criDto + "]";
	}

}
