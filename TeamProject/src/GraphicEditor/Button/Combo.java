package GraphicEditor.Button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import GraphicEditor.ButtonPanel;
import GraphicEditor.GraphicEditor;

import java.awt.event.*;

public class Combo extends JComboBox<String> implements ActionListener{
	public JComboBox<String> combo;
	private String toolcombo[] = {"모두지우기", "픽셀지우개"};
	public static String comboButtonStr;
	
	public Combo() {
		combo = new JComboBox<>();
		
		for(int i = 0; i<2; i++) {
			combo.addItem(toolcombo[i]);
		}
//		combo.setOpaque(true);
		combo.setBounds(15,100,120,40);
		combo.setBackground(Color.WHITE);
		combo.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		comboButtonStr = combo.getSelectedItem().toString();
		ButtonPanel.miniToolLabel.label.setText(comboButtonStr);
		Normal.normalButtonStr = "";
		TextBox.textBoxStr = "";
		
		if(comboButtonStr == "모두지우기") {
			GraphicEditor.mp.repaint();
		}
	}
}
