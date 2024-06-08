package GraphicEditor.Button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import GraphicEditor.ButtonPanel;
import GraphicEditor.Label;

public class TextBox extends JFrame implements ActionListener, KeyListener{
	public JButton button; //일반 버튼
	private JButton doneButton;
	private JFrame textFrame;
	private JPanel textPanel;
	private JTextField inputText;
	private Label fontLabel, sizeLabel, bLabel, iLabel, nowLabel, addLabel1, addLabel2;
	public static String inputStr;
	public static String textBoxStr;
	
	public TextBox(String s) {
		button = new JButton(s);
		button.setOpaque(true);
		button.setBackground(Color.GRAY);
		button.addActionListener(this);
	}
	
	public void textFrame() {
		textFrame = new JFrame("텍스트 박스");
		textFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		textFrame.setLocation(300,200);
		textFrame.setSize(330,315);
		
		//Panel만들기
		textPanel = new JPanel();
		textPanel.setBackground(Color.WHITE);
		textPanel.setLayout(null);
		textFrame.add(textPanel);
		
		//panel 안에 들어갈 textField
		inputText = new JTextField();
		textPanel.add(inputText);
		inputText.setText("입력을 원하는 문자를 입력하세요.");
		inputText.setBounds(30,30,270,40);
		inputText.addKeyListener(this);
		
		//Label 생성
		nowLabel = new Label("* 현재 텍스트 상태 *", 30, 80, 270, 20, Color.BLACK);
		fontLabel = new Label(("- 글꼴 : " + Text.fontButtonStr), 30, 100, 270, 20, Color.BLACK);
		fontLabel.label.setHorizontalAlignment(SwingConstants.LEFT);
		sizeLabel = new Label(("- 글자크기 : " + Integer.toString(Text.textFontSize)), 30, 120, 240, 20, Color.BLACK);
		sizeLabel.label.setHorizontalAlignment(SwingConstants.LEFT);
		if(Text.boldItalicStr == "All") {
			bLabel = new Label("- Bold : O", 30, 140, 270, 20, Color.BLACK);
			iLabel = new Label("- Italic : O", 30, 160, 270, 20, Color.BLACK);
		}else if(Text.boldItalicStr == "Bold") {
			bLabel = new Label("- Bold : O", 30, 140, 270, 20, Color.BLACK);
			iLabel = new Label("- Italic : X", 30, 160, 270, 20, Color.BLACK);
		}else if(Text.boldItalicStr == "Italic") {
			bLabel = new Label("- Bold : O", 30, 140, 270, 20, Color.BLACK);
			iLabel = new Label("- Italic : O", 30, 160, 270, 20, Color.BLACK);
		}else {
			bLabel = new Label("- Bold : X", 30, 140, 270, 20, Color.BLACK);
			iLabel = new Label("- Italic : X", 30, 160, 270, 20, Color.BLACK);
		}
		bLabel.label.setHorizontalAlignment(SwingConstants.LEFT);
		iLabel.label.setHorizontalAlignment(SwingConstants.LEFT);
		addLabel1 = new Label("*현재상태를 수정하기 원한다면", 30, 180, 260, 20, Color.BLACK);
		addLabel2 = new Label("T속성을 수정해 주세요!", 30, 200, 260, 20, Color.BLACK);
		addLabel1.label.setHorizontalAlignment(SwingConstants.RIGHT);
		addLabel2.label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		//Label add
		textPanel.add(nowLabel.label);
		textPanel.add(fontLabel.label);
		textPanel.add(sizeLabel.label);
		textPanel.add(bLabel.label);
		textPanel.add(iLabel.label);
		textPanel.add(addLabel1.label);
		textPanel.add(addLabel2.label);
		
		//new Button
		doneButton = new JButton("입력완료");
		doneButton.setVerticalAlignment(SwingConstants.CENTER);
		doneButton.setHorizontalAlignment(SwingConstants.CENTER);
		doneButton.setBounds(115,230,100,30);
		doneButton.addActionListener(this);
		
		textPanel.add(doneButton);

		textFrame.setVisible(true);
	}
	
	//Button Action
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "T박스") {
			textBoxStr = e.getActionCommand();
			ButtonPanel.miniToolLabel.label.setText(textBoxStr);
			Combo.comboButtonStr = "";
			Normal.normalButtonStr = "";
			textFrame();
		}
		else if(e.getActionCommand() == "입력완료") {
			inputStr = inputText.getText();
			textFrame.dispose();
		}
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			inputStr = inputText.getText();
			textFrame.dispose();
		}
	}

	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
