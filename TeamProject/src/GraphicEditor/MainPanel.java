package GraphicEditor;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import GraphicEditor.Label;
import GraphicEditor.Button.*;
import java.util.ArrayList;
import java.util.Stack;

public class MainPanel extends JPanel implements MouseListener, MouseMotionListener{
	public static ArrayList<Figure> fList;
	public static ArrayList<Point> penList;
	public static Stack<Figure> doStack;
	public static Point sp, ep;
	private String bStr, cbStr, mStr, tStr;
	public static int showGrid = -1;
	
	public MainPanel() {
		this.setBackground(Color.WHITE); //panel color
		
		this.setBounds(150, 0, 1000, 600); //panel 크기
		this.setLayout(null);
		
		this.add(Text.textPanel);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		sp = null;
		ep = null;
		
		fList = new ArrayList<>();
		penList = new ArrayList<>();
		doStack = new Stack<>();
	}
	
	public void paintComponent(Graphics g2) {
		super.paintComponent(g2);
		Graphics2D g = (Graphics2D)g2;
//		Graphics2D g = bufferedImage.createGraphics();
		bStr = Normal.normalButtonStr;
		cbStr = Combo.comboButtonStr;
		mStr = MenuBar.barButton;
		tStr = TextBox.textBoxStr;
		
		if(fList.size() != 0) {
			for(int i = 0; i<fList.size(); i++) {
				Figure temp = fList.get(i);
				if(temp.bStr != "T박스") {
					g.setColor(temp.newColor);
					g.setStroke(new BasicStroke(temp.sizeValue,BasicStroke.CAP_ROUND,0));
				}
				
				if(temp.bStr == "선") g.drawLine(temp.sp.x, temp.sp.y, temp.ep.x, temp.ep.y);
				else if(temp.bStr == "네모") {
					g.drawRect((Math.min(temp.sp.x, temp.ep.x)), Math.min(temp.sp.y, temp.ep.y),Math.abs(temp.ep.x- temp.sp.x),Math.abs(temp.ep.y- temp.sp.y));
				}else if(temp.bStr == "원") {
					g.drawOval((Math.min(temp.sp.x, temp.ep.x)), Math.min(temp.sp.y, temp.ep.y),Math.abs(temp.ep.x- temp.sp.x),Math.abs(temp.ep.y- temp.sp.y));
				}else if(temp.bStr == "T박스") {
					g.setColor(temp.newColor);
					if(temp.boldItalicStr == "All") {
						g.setFont(new Font(temp.fontButtonStr, Font.BOLD + Font.ITALIC, temp.textFontSize));
					}else if(temp.boldItalicStr == "Bold") {
						g.setFont(new Font(temp.fontButtonStr, Font.BOLD, temp.textFontSize));
					}else if(temp.boldItalicStr == "Italic") {
						g.setFont(new Font(temp.fontButtonStr, Font.ITALIC, temp.textFontSize));
					}else {
						g.setFont(new Font(temp.fontButtonStr, Font.PLAIN, temp.textFontSize));
					}
					g.drawString(temp.inputStr, temp.sp.x, temp.sp.y);
				}else if(temp.bStr == "펜" || temp.bStr == "픽셀지우개"){
					for(int j = 0; j<temp.penList.size()-1; j++) {
						g.drawLine(temp.penList.get(j).x, temp.penList.get(j).y, temp.penList.get(j+1).x, temp.penList.get(j+1).y);
					}
				}else if(temp.bStr == "모두지우기") {
					g.setColor(Color.WHITE);
					g.fillRect(0,0,1000,600);
				}
			}
		}
		
		if(showGrid == 1) {
			for(int i = 0; i<100; i++) {
				g.setColor(Color.LIGHT_GRAY);
				g.drawLine(i*15, 0, i*15, 600);
				g.drawLine(0, i*15, 1000, i*15);
			}
		}
		
		if(sp != null) {
			g.setStroke(new BasicStroke(Size.sizeValue,BasicStroke.CAP_ROUND,0));
			if(cbStr == "픽셀지우개") {
				g.setColor(Color.WHITE);
				for(int i = 0; i<penList.size()-1; i++) {
					g.drawLine(penList.get(i).x, penList.get(i).y, penList.get(i+1).x, penList.get(i+1).y);
				}
			}else if(cbStr == "모두지우기") {
				g.setColor(Color.WHITE);
				g.fillRect(0,0,1000,600);
				fList.add(new Figure(cbStr));
				Combo.comboButtonStr = "";
				cbStr = Combo.comboButtonStr;
				if(showGrid == 1) {
					for(int j = 0; j<100; j++) {
						g.setColor(Color.LIGHT_GRAY);
						g.drawLine(j*15, 0, j*15, 600);
						g.drawLine(0, j*15, 1000, j*15);
					}
				}
			}
			
			g.setColor(BColor.newColor);
			if(bStr == "선") {
				g.drawLine(sp.x, sp.y, ep.x, ep.y);
			}else if(bStr == "네모") {
				g.drawRect((Math.min(sp.x, ep.x)), Math.min(sp.y, ep.y),Math.abs(ep.x- sp.x),Math.abs(ep.y- sp.y));
			}else if(bStr == "원") {
				g.drawOval((Math.min(sp.x, ep.x)), Math.min(sp.y, ep.y),Math.abs(ep.x- sp.x),Math.abs(ep.y- sp.y));
			}else if(bStr == "펜") {
				for(int i = 0; i<penList.size()-1; i++) {
					g.drawLine(penList.get(i).x, penList.get(i).y, penList.get(i+1).x, penList.get(i+1).y);
				}
			}else if(tStr == "T박스") {
				if(Text.boldItalicStr == "All") {
					g.setFont(new Font(Text.fontButtonStr, Font.BOLD + Font.ITALIC, Text.textFontSize));
				}else if(Text.boldItalicStr == "Bold") {
					g.setFont(new Font(Text.fontButtonStr, Font.BOLD, Text.textFontSize));
				}else if(Text.boldItalicStr == "Italic") {
					g.setFont(new Font(Text.fontButtonStr, Font.ITALIC, Text.textFontSize));
				}else {
					g.setFont(new Font(Text.fontButtonStr, Font.PLAIN, Text.textFontSize));
				}
				g.drawString(TextBox.inputStr, ep.x, ep.y);
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
		penList = new ArrayList<>();
		sp = e.getPoint();
		penList.add(e.getPoint());
	}

	public void mouseReleased(MouseEvent e) {
		if(bStr != "펜" && cbStr != "픽셀지우개" && tStr != "T박스") {
			ep = e.getPoint();
			fList.add(new Figure(bStr, BColor.newColor, Size.sizeValue, sp, ep));
		}else if(cbStr == "픽셀지우개"){
			penList.add(e.getPoint());
			fList.add(new Figure(cbStr, Color.WHITE, Size.sizeValue, penList));
		}else if(bStr == "펜"){
			penList.add(e.getPoint());
			fList.add(new Figure(bStr, BColor.newColor, Size.sizeValue, penList));
		}else if(tStr == "T박스") {
			ep = e.getPoint();
			fList.add(new Figure(tStr, BColor.newColor, TextBox.inputStr, ep, Text.fontButtonStr, Text.textFontSize, Text.boldItalicStr));
		}
		this.repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		if(bStr != "펜" && cbStr != "픽셀지우개") ep = e.getPoint();
		else penList.add(e.getPoint());
		
		this.repaint();
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {
		ButtonPanel.locationLabel.label.setText(("x  :  " + e.getPoint().x + ",   y  :  " + e.getPoint().y));
	}
}
