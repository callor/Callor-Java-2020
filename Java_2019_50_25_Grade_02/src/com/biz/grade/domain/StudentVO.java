package com.biz.grade.domain;

/*
 * 학번, String, num
 * 이름, String, name
 * 전화번호, String, tel
 * 주소, String, addr
 */
public class StudentVO {

	private String num;
	private String name;
	private String tel;
	private String addr;
	
	public StudentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentVO(String num, String name, String tel, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "StudentVO [num=" + num + ", name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
	
	
	
}
