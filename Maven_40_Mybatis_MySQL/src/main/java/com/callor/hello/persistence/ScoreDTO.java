package com.callor.hello.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ScoreDTO {
	private long s_id;//	int(11)
	private String s_std;//	varchar(50)
	private String s_subject;//	varchar(50)
	private int s_score;//	int(3)
	private String s_rem;//	varchar(50)
}

