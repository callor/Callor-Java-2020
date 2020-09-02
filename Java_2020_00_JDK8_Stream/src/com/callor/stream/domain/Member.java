package com.callor.stream.domain;

public class Member {
		private String name;
		private MemberEnum sex;
		private int age;
		public Member(String name, MemberEnum sex, int age) {
			super();
			this.name = name;
			this.sex = sex;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public MemberEnum getSex() {
			return sex;
		}
		public void setSex(MemberEnum sex) {
			this.sex = sex;
		}
		
		
		

}
