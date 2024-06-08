package GraphicEditor;

import javax.swing.*;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MenuBar extends JMenuBar implements ActionListener{	
	public JMenuBar menuBar;
	private JMenu menu[] = new JMenu[5];
	private String menuTitle[] = {"  파일  ", "  보기  ","  🔙/🔜  "};
	private JMenuItem item[][] = new JMenuItem[3][4];
	private String itemTitle[][] = {{"새로 만들기", "열기", "저장", "정보"}, {"격자", "상태표시"}, {"🔙", "🔜"}};
	public static String barButton;
	private JFrame info;
	private JPanel infoPanel;
	private JLabel infoLabel;
//	public BufferedImage bufferedImage;
	
	public MenuBar() {
		//메뉴바 생성
		menuBar = new JMenuBar();
				
		//menu 생성 및 추가
		for(int i = 0; i<3; i ++) {
			menu[i] = new JMenu(menuTitle[i]);
			menuBar.add(menu[i]);
		}
		
		//메뉴별 아이템 생성 및 추가
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<4; j++) {
				if(i >= 2 && j >= 2) break;
				if(i == 1 && j >= 2) break;
				item[i][j] = new JMenuItem(itemTitle[i][j]);
				menu[i].add(item[i][j]);
				item[i][j].addActionListener(this);
				menu[i].addActionListener(this);
				if(i == 2 && j == 0) menu[i].addSeparator();
				else if(i == 0 && j != 3 || i == 1 && j < 1) menu[i].addSeparator();
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		barButton = e.getActionCommand();
		if(barButton == "새로 만들기") {
			System.out.println("새로 만들기");
		}else if(barButton == "열기") {
			System.out.println("열기");
		}else if(barButton == "저장") {
			System.out.println("저장");
//			Dimension d = getPreferredSize();
//			BufferedImage bufferedImage = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
//			GraphicEditor.mp.setImageBackground(bufferedImage);
//			new Save(GraphicEditor.mp, bufferedImage);
		}else if(barButton == "정보") {
			info = new JFrame("GraphicEditor 정보");
			info.setSize(300,150);
			info.setLocation(400,200);
			
			infoPanel = new JPanel();
			infoPanel.setBackground(Color.WHITE);
			info.add(infoPanel);
			
			infoLabel = new JLabel("<html><body style='text-align:center;'><br>Jaba Programming 02<br>*GraphicEditor*<br><br>Nuri Sung, Jiwon Lee, Woohyun Kim</body></html>", JLabel.CENTER);
			infoPanel.add(infoLabel);
			info.setVisible(true);
		}else if(barButton == "격자") {
			MainPanel.showGrid *= -1;
			GraphicEditor.mp.repaint();
		}else if(barButton == "눈금자") {
			System.out.println("눈금자");
		}else if(barButton == "상태표시") {
			ButtonPanel.showLocationPanel *= -1;
			if(ButtonPanel.showLocationPanel == 1) ButtonPanel.locationPanel.panel.setVisible(true);
			else if(ButtonPanel.showLocationPanel == -1) ButtonPanel.locationPanel.panel.setVisible(false);
		}else if(barButton == "🔙") {
			if(MainPanel.fList.size() > 0) {
				Figure t = MainPanel.fList.get(MainPanel.fList.size()-1);
				MainPanel.fList.remove(MainPanel.fList.size()-1);
				MainPanel.doStack.add(t);
				MainPanel.penList = new ArrayList<>();
				MainPanel.sp = null;
				MainPanel.ep = null;
				GraphicEditor.mp.repaint();
			}
		}else if(barButton == "🔜") {
			if(MainPanel.doStack.size() > 0) {
				Figure t = MainPanel.doStack.pop();
				MainPanel.fList.add(t);
				GraphicEditor.mp.repaint();
			}
		}
	}
}
