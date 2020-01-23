package com.callor.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CvsParsingFromScanner {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("src/main/java/com/callor/files/한국연예인.txt"));
		Scanner valueScanner = null;
		int index = 0;
		List<UserVO> userList = new ArrayList<>();

		while (scanner.hasNextLine()) {
			valueScanner = new Scanner(scanner.nextLine());
			valueScanner.useDelimiter(":");
			UserVO user = new UserVO();

			while (valueScanner.hasNext()) {
				String strS = valueScanner.next();
				if (index == 0) {
					user.set예명(strS);
				} else if (index == 1) {
					user.set본명(strS);
				}
				index++;
			}
			index = 0;
			userList.add(user);
		}

		scanner.close();

		System.out.println(userList);

	}

}
