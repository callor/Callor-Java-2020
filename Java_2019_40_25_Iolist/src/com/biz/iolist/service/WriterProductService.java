package com.biz.iolist.service;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class WriterProductService {

	List<String> productList;

	public WriterProductService() {
	}
	
	public WriterProductService(List<String> productList) {
		this.productList = productList;
	}
	
	public void setProList(List<String> productList) {
		this.productList = productList;
	}
	
	public void productWrite(String proWriteFile) throws Exception {
	
		if(productList == null) {
			System.out.println("상품이름 리스트가 없음");
			return;
		}
		
		PrintWriter fileOut = new PrintWriter(proWriteFile);
		for(String pro : productList) {
			fileOut.println(pro);
		}
		fileOut.close();
	}
	
}
