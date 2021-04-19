package com.callor.image;

import java.awt.Color;

public class Utils {
	public static Color getColor(String textColor) {
        if (textColor == null || textColor.length() != 7) {
            throw new RuntimeException("Web Color 를 입력해 주세요.");
        }
        return new Color(
                Integer.valueOf(textColor.substring(1, 3), 16),
                Integer.valueOf(textColor.substring(3, 5), 16),
                Integer.valueOf(textColor.substring(5, 7), 16)
        );
    }
}
