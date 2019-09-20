package com.callor.files.service;

import java.io.IOException;

public interface FileGradeService {
	
	
	public void read(String fileName) throws IOException ;
	public void list();
	public void total();

}
