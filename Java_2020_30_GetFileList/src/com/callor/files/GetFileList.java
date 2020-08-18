package com.callor.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
 * 특정 디렉토리(폴더)내의 파일 리스트 얻엉오기
 */
public class GetFileList {
	
	public static void main(String[] args) {
		String folder = "C:/Users/callor/Downloads";
		GetFileList gf = new GetFileList();
		
		List<String> files = new ArrayList<String>();
		gf.getFileList(new File(folder), files);
		for(String f : files) {
			System.out.println(f);
		}
		
	}
	
	// getFileList(new File("/bizwork/upload"), arr);
	public void  getFileList(File targetPath, List<String> arr) {
		long timeBefore = 86400; // 하루(86400초) 이전 수정된 파일만.

		if (targetPath.isDirectory()) {
			String[] fl = targetPath.list();
			File tmpFile = null;
			long nTmp;
			int filecnt = 0;

			for (int i = 0; i < fl.length; i++) {
				tmpFile = new File(targetPath.getAbsolutePath() + File.separator + fl[i]);
		
				if (tmpFile.isDirectory()) {
					getFileList(tmpFile, arr);
				} else {
					// if (fl[i].substring(fl[i].lastIndexOf(".")).equalsIgnoreCase(".*")) { // 확장자가 java인 경우만
						nTmp = tmpFile.lastModified();
						nTmp = new java.util.Date().getTime() - nTmp;
						nTmp /= 1000; // ms를 초단위로 변경
//						if (nTmp <= timeBefore) { // 시간내 변경된 파일만
							arr.add(targetPath.getAbsolutePath() + "/" + fl[i]);
							filecnt++;
//						}
					 // }
				}
			}
			System.out.println("파일 갯수 : " + filecnt);
		}
	}
}
