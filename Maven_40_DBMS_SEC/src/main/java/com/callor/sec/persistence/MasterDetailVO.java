package com.callor.sec.persistence;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MasterDetailVO {

	/*
	 * tbl_master 테이블 1개의 레코드를 추출하고
	 * 그 레코드의 m_seq값과 일치하는 tbl_detail 테이블의
	 * 레코드들을 추출해서
	 * 이들을 한묶음으로 해서 VO에 담겠다.
	 */
	// tbl_master 테이블의 칼럼들
	private long m_seq;
	private String m_subject;
	
	// DetailDTO : tbl_detail 테이블의 칼럼들
	// DetailDTO를 여러개 포함할수 있는 List 변수로 추가
	private List<DetailDTO> deList; // property
	
}
