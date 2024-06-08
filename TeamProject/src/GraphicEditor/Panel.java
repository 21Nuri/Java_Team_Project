package GraphicEditor;

import java.awt.*;
import javax.swing.*;

import GraphicEditor.Button.BColor;

public class Panel extends JPanel{
	public JPanel panel;
	
	public Panel(int x, int y, int w, int h, Color c) {
		//new Panel
		panel = new JPanel();

		//panel 색상
		panel.setBackground(c);
		
		//panel 사이즈 지정
		panel.setBounds(x, y, w, h);
	}
}
