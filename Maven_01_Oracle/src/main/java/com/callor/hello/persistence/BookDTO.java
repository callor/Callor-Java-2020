package com.callor.hello.persistence;

import lombok.ToString;

@ToString
public class BookDTO {
	
	private String b_code;	//varchar2(5 byte)
	private String b_name;	//nvarchar2(50 char)
	private String b_comp;	//nvarchar2(50 char)
	private String b_writer;	//nvarchar2(50 char)
	private int b_price;	//number

}
