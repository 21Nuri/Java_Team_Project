package GraphicEditor.Button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import GraphicEditor.*;
//import javax.swing.colorchooser.*;

public class BColor extends JFrame implements ActionListener, ChangeListener{
	public JButton color; //color 버튼
	public JFrame colorFrame; //color Frame
	private JColorChooser colorChooser = new JColorChooser();
	public static Color newColor = Color.BLACK; //new color
	
	public BColor(String s) {
		color = new JButton(s);
		color.setOpaque(true);
		color.setBackground(Color.GRAY);
		color.addActionListener(this);
	}
	
	//color 표에서 색 받아오기
	public void stateChanged(ChangeEvent e) {
		newColor = colorChooser.getColor();
		ButtonPanel.miniColorPanel.panel.setBackground(newColor);
	}
	
	//색상표 Frame 만들기
	public void colorChooserFrame() {
		colorFrame = new JFrame("색상표");
		colorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		colorFrame.setLocation(400,200);
		colorChooser.getSelectionModel().addChangeListener(this);
		colorChooser.setBorder(BorderFactory.createTitledBorder("색상 선택"));
		
		colorFrame.add(colorChooser);
		colorFrame.pack();
		colorFrame.setVisible(true);
	}
	
	//color button이 눌렸을때
	public void actionPerformed(ActionEvent e) {
		colorChooserFrame();
	}
}
