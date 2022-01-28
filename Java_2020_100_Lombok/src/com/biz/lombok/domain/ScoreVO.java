package com.biz.lombok.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScoreVO {

	private String sc_num;
	private int sc_kor;
	private int sc_eng;
	private int sc_math;
	private int sc_total;
	private int sc_avg;
	
}
