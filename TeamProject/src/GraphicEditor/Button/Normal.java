package GraphicEditor.Button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import GraphicEditor.ButtonPanel;

public class Normal extends JButton implements ActionListener{
	public JButton button; //일반 버튼
	public static String normalButtonStr; //버튼 눌렀을 때 버튼의 내용
	
	public Normal(){}
	public Normal(String s) {
		button = new JButton(s);
		button.setOpaque(true);
		button.setBackground(Color.GRAY);
		button.addActionListener(this);
	}
	
	//Button Action
	public void actionPerformed(ActionEvent e) {
		normalButtonStr = e.getActionCommand();
		ButtonPanel.miniToolLabel.label.setText(normalButtonStr);
		Combo.comboButtonStr = "";
		TextBox.textBoxStr = "";
	}
}
