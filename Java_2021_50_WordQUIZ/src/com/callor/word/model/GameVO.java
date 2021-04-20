package com.callor.word.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GameVO {

	private WordVO wordVO;
	private String[] suffleWord;
	
	private Integer 포인트 = 0;
	private Integer 맞은개수 = 0;
	private Integer 틀린개수 = 0;
	
	private Integer 재도전 = 0;
	private Integer 힌트보기 = 0;
	
	public GameVO() {
		this(3);
	}

	public GameVO(Integer 재도전) {
		this.재도전 = 재도전;
	}
	
}
