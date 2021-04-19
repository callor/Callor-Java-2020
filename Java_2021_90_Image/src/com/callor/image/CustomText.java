package com.callor.image;

import java.awt.Color;
import java.awt.Font;
import java.util.Objects;

import lombok.Builder;


@Builder
public class CustomText {
	private String text;
    private String fontFamily;
    private int fontSize;
    private String fontColor;
    private FontStyle fontStyle;

    public enum FontStyle {
        PLAIN, BOLD, ITALIC
    }
    
    
    public CustomText(String text, String fontFamily, Integer fontSize, String fontColor, FontStyle fontStyle) {
        this.text = Objects.requireNonNull(text);
        this.fontFamily = Objects.requireNonNull(fontFamily);
        this.fontSize = Objects.requireNonNull(fontSize);
        this.fontColor = Objects.requireNonNull(fontColor);
        this.fontStyle = fontStyle == null ? FontStyle.PLAIN : fontStyle;
    }

    
    
    public String getText() {
		return text;
	}



	public String getFontFamily() {
		return fontFamily;
	}



	public int getFontSize() {
		return fontSize;
	}



	public String getFontColor() {
		return fontColor;
	}



	public Font getFont() {
        return new Font(this.fontFamily, this.getFontStyle(), this.fontSize);
    }

    private int getFontStyle() {
        switch (this.fontStyle) {
            case BOLD: return Font.BOLD;
            case ITALIC: return Font.ITALIC;
            default: return Font.PLAIN;
        }
    }

    public Color getColor() {
        return Utils.getColor(this.fontColor);
    }


}
