package GraphicEditor;

import java.awt.*;
import javax.swing.*;

public class Label extends JLabel{
	public JLabel label;
	
	public Label(String s, int x, int y, int w, int h, Color c) {
		//new Label
		label = new JLabel(s);
		
		//Label 정렬
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Label 사이즈 지정
		label.setBounds(x,y,w,h);

		//textColor 변경
		label.setForeground(c);
	}
	
}
