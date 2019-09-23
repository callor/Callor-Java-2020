package com.callor.bank.service;

/*
 * 은행계정계 app Service
 */
public interface BankAccService {

	public boolean viewAcc() throws Exception;
	public void input() throws Exception;
	public void output() throws Exception;
	
	public void bankBookList();
	public void writeAccBook(String bookFileName);
	
}
