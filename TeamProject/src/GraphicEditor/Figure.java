package GraphicEditor;

import java.awt.*;
import java.util.ArrayList;

public class Figure {
	public String bStr;
	public Color newColor;
	public int sizeValue;
	public int width;
	public int hight;
	public Point sp;
	public Point ep;
	public ArrayList<Point> penList;
	public String inputStr;
	public String fontButtonStr;
	public int textFontSize;
	public String boldItalicStr;
	
	public Figure(String bStr, Color newColor, int sizeValue, Point sp, Point ep) {
		this.bStr = bStr;
		this.newColor = newColor;
		this.sizeValue = sizeValue;
		this.sp = sp;
		this.ep = ep;
	}
	
	public Figure(String bStr, Color newColor, int sizeValue, ArrayList<Point> penList) {
		this.bStr = bStr;
		this.newColor = newColor;
		this.sizeValue = sizeValue;
		this.penList = penList;
	}
	
	public Figure(String bStr) {
		this.bStr = bStr;
	}
	
	public Figure(String bStr, Color newColor, String inputStr, Point sp, String fontButtonStr, int textFontSize, String boidItalicStr) {
		this.bStr = bStr;
		this.newColor = newColor;
		this.inputStr = inputStr;
		this.sp = sp;
		this.fontButtonStr = fontButtonStr;
		this.textFontSize = textFontSize;
		this.boldItalicStr = boldItalicStr;
	}
}
