package com.callor.enums;

public class HostSectionEx {
	
	private enum HostSection {내부,외부}
	private String getData(String host, HostSection hostSection) {
		
		if(hostSection == HostSection.내부) {
			return host + "의 내부에서 외부로";
		} else {
			return host + "의 외부에서 접근";
		}
	}
	
	
	public static void main(String[] args) {
		
		HostSectionEx hoEx = new HostSectionEx();
		System.out.println(hoEx.getData("localhost", HostSection.내부));
		System.out.println(hoEx.getData("localhost", HostSection.외부));
		
	}
	

}
