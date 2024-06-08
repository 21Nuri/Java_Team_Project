package GraphicEditor.Button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;

import GraphicEditor.ButtonPanel;


public class Text extends JPanel implements ActionListener, KeyListener{
	public JButton text; //텍스트 버튼
	public static JPanel textPanel; //텍스트 버튼을 누르면 생기는 Panel
	public static int showTextPanel = -1; //텍스트 버튼이 눌리면 1, 아니면 -1
	private JComboBox<String> fontCombo;
	private String font[] = {"Dialog","DialogInput" ,"SansSerif","Serif", "Monospaced"};
	public static String fontButtonStr = "Dialog";
	private JTextField textFont;
	public static int textFontSize = 10;
	private JButton upDownButton[] = new JButton[2];
	private String upDownStr[] = {"+", "-"};
	private String fUpDown;
	private JCheckBox boldICheckBox[] = new JCheckBox[2];
	private String boldICheckStr[] = {"Bold", "Italic"};
	public static String boldItalicStr = null;
	
	public Text(String s) {
		text = new JButton(s); //텍스트 버튼을 생성
		text.setOpaque(true); //버튼에 색상이 들어가게 만들기
		text.setBackground(Color.GRAY); //색상지정
		text.addActionListener(this); //event
		textPanel(); //Panel 생성
	}
	
	//text Panel 생성
	public void textPanel() {
		textPanel = new JPanel(); //new panel
		textPanel.setBounds(0,0,400,40); //size, location
		textPanel.setBackground(Color.LIGHT_GRAY); //color
		textPanel.setVisible(false); //visible
		textPanel.setLayout(null);
		
		//Font box
		fontCombo = new JComboBox<>();
		for(int i = 0; i<font.length; i++) fontCombo.addItem(font[i]);
		fontCombo.setBackground(Color.WHITE);
		fontCombo.setBounds(0,0,130,40);
		fontCombo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	fontButtonStr = fontCombo.getSelectedItem().toString();
            	if(fontButtonStr == "Dialog") {
        			System.out.println("Dialog");
        		}else if(fontButtonStr == "DialogInput") {
        			System.out.println("DialogInput");
        		}else if(fontButtonStr == "SansSerif") {
        			System.out.println("SansSerif");
        		}else if(fontButtonStr == "Serif") {
        			System.out.println("Serif");
        		}else if(fontButtonStr == "Monospaced") {
        			System.out.println("Monospaced");
        		}
            }});
		textPanel.add(fontCombo);
		
		//Text Font size
		textFont = new JTextField();
		textPanel.add(textFont);
		textFont.setText(Integer.toString(textFontSize));
		textFont.setBounds(135, 0, 50, 40);
		textFont.addKeyListener(this);
		
		//TextFont size Button
		for(int  i = 0; i<2; i++) {
			upDownButton[i] = new JButton(upDownStr[i]);
			textPanel.add(upDownButton[i]);
			
			upDownButton[i].setBounds(190,5+i*15,15,15);
			upDownButton[i].setOpaque(true);
			upDownButton[i].setBackground(Color.LIGHT_GRAY);
			upDownButton[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					fUpDown = e.getActionCommand();
					if(fUpDown == "+") textFontSize += 1;
					else if(fUpDown == "-") textFontSize -= 1;
					if(textFontSize < 0) textFontSize = 0;
					textFont.setText(Integer.toString(textFontSize));
				}
			});
		}
		
		//TextFont Style
		for(int i = 0; i<2; i++) {
			boldICheckBox[i] = new JCheckBox(boldICheckStr[i]);
			textPanel.add(boldICheckBox[i]);
			
			boldICheckBox[i].setBounds(210 + i*80, 0, 80, 40);
			boldICheckBox[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(boldICheckBox[0].isSelected() && boldICheckBox[1].isSelected()) {
						boldItalicStr = "All";
					}else if(boldICheckBox[0].isSelected()) {
						boldItalicStr = "Bold";
					}else if(boldICheckBox[1].isSelected()) {
						boldItalicStr = "Italic";
					}else boldItalicStr = null;
				}
			});
		}
	}
	
	//text ection
	public void actionPerformed(ActionEvent e) {
		showTextPanel *= -1; //버튼이 눌리면 양음 변화
		if(showTextPanel == 1) textPanel.setVisible(true); //눌려서 panel이 보이게
		else if(showTextPanel == -1) textPanel.setVisible(false); //눌려서 panel이 안보이게
	}
	
	public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
        	textFontSize = Integer.parseInt(textFont.getText());
        	if(textFontSize < 0) textFontSize = 0;
        	textFont.setText(Integer.toString(textFontSize));
        }
    }
	
	public void keyTyped(KeyEvent e){	}
	public void keyReleased(KeyEvent e) {	}
}
