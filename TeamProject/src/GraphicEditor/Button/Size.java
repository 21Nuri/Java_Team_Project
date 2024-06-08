package GraphicEditor.Button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import GraphicEditor.ButtonPanel;

public class Size extends JFrame implements ActionListener, ChangeListener, KeyListener{
	public JButton size; //굵기 버튼
	public JFrame sizeFrame; //굵기 수정하는 Frame
	private JPanel sizePanel; //굵기 수정하는 panel
	private JSlider sizeSlider; //굵기 수정하는 Slider
	private JTextField sizeText;
	public static int sizeValue = 1; //size값
	
	public Size(String s) {
		size = new JButton(s);
		size.setOpaque(true);
		size.setBackground(Color.GRAY);
		size.addActionListener(this);
	}
	
	//size Frame 만들기
	public void sizeFrame() {
		sizeFrame = new JFrame("굵기");
		sizeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		sizeFrame.setLocation(300,200);
		sizeFrame.setSize(250,150);
		
		//Panel만들기
		sizePanel = new JPanel();
		sizePanel.setBackground(Color.WHITE);
		sizePanel.setLayout(null);
		sizeFrame.add(sizePanel);
		
		//panel 안에 들어갈 Slider
		sizeSlider = new JSlider(0, 50, sizeValue);
		sizePanel.add(sizeSlider);
		sizeSlider.setBounds(0,0,250,75);
		sizeSlider.setMajorTickSpacing(5);
		sizeSlider.setMinorTickSpacing(1);
		sizeSlider.setPaintTicks(true);
		sizeSlider.setPaintLabels(true);
		sizeSlider.addChangeListener(this);
		
		//panel 안에 들어갈 textField
		sizeText = new JTextField();
		sizePanel.add(sizeText);
		sizeText.setText(Integer.toString(sizeValue));
		sizeText.setBounds(75,73,100,40);
		sizeText.addKeyListener(this);
		
		sizeFrame.setVisible(true);
	}
	
	//size Action
	public void actionPerformed(ActionEvent e) {
		sizeFrame();
	}
	
	public void stateChanged(ChangeEvent e) {
		sizeValue = sizeSlider.getValue();
		sizeText.setText(Integer.toString(sizeValue));
		ButtonPanel.miniSizeLabel.label.setText(Integer.toString(sizeValue));
	}
	
	public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
        	sizeValue = Integer.parseInt(sizeText.getText());
        	sizeText.setText(Integer.toString(sizeValue));
    		ButtonPanel.miniSizeLabel.label.setText(Integer.toString(sizeValue));
    		sizeSlider.setValue(sizeValue);
        }
    }
	
	public void keyTyped(KeyEvent e){	}
	public void keyReleased(KeyEvent e) {	}
}
