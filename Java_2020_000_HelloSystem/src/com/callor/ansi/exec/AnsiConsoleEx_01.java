package com.callor.ansi.exec;

import com.callor.ansi.config.AnsiColorEnum;

public class AnsiConsoleEx_01 {
	public static void main(String[] args) {

        System.out.print(AnsiColorEnum.BLACK_BOLD);
        System.out.println("Black_Bold");
        System.out.print(AnsiColorEnum.RESET);

        System.out.print(AnsiColorEnum.YELLOW);
        System.out.print(AnsiColorEnum.BLUE_BACKGROUND);
        System.out.println("YELLOW & BLUE");
        System.out.print(AnsiColorEnum.RESET);

        System.out.print(AnsiColorEnum.YELLOW);
        System.out.println("YELLOW");
        System.out.print(AnsiColorEnum.RESET);
    }
}
