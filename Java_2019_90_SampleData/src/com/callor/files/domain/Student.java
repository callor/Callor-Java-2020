package com.callor.files.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

	private String num;
	private String name;
	private int gradeNum;
	private int className;
	
	private String addr;
	
	
}
