package GraphicEditor;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GraphicEditor extends JFrame{
	public JPanel allPanel;
	public static MainPanel mp;
	public GraphicEditor() {
		//기본 창 만들기
		setTitle("GraphicEditor"); 
//		setSize(1000, 755);
		setExtendedState(JFrame.MAXIMIZED_BOTH); //full screen
//		setUndecorated(true); //full !!!! screen
		setLocation(0,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//allPanel 만들기
		allPanel = new JPanel(); //제일 큰 panel
		allPanel.setLayout(null); //allPanel 정렬
		
		ButtonPanel bp = new ButtonPanel(); //ButtonPanel 불러오기
		mp = new MainPanel(); //MainPanel 불러오기
		
		//allPanel에 panel 추가
		allPanel.add(bp.buttonPanel);
		allPanel.add(mp);

		//MenuBar 생성
		MenuBar mb = new MenuBar();
		setJMenuBar(mb.menuBar);
		
		add(allPanel); //frame 에 panel 추가
		setVisible(true); //화면에 뜨도록 하기
	}
	
	public static void main(String[] args) {
		new GraphicEditor();
	}
}
