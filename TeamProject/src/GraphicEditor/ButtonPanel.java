package GraphicEditor;

import java.awt.*;
import javax.swing.*;
import GraphicEditor.Button.*;

public class ButtonPanel extends JFrame {
	public static JPanel buttonPanel;
	private Panel statusPanel, toolPanel, drawPanel, colorPanel, miniSizePanel, miniToolPanel;
	public static Panel miniColorPanel, locationPanel;
	private Label statusLabel, toolLabel, drawLabel, colorLabel;
	public static Label miniSizeLabel, miniToolLabel, locationLabel;
	
	private Normal toolButton[] = new Normal[2];
	private String toolTitle[] = {"펜", "마우스"};
	private Combo toolCombo;
	private Size sizeButton;
	private Text textButton;
	private Normal drawButton[] = new Normal[3];
	private String drawTitle[] = {"선", "네모", "원"};
	private TextBox textBoxButton;
	private BColor colorButton;
	private Normal pipetteButton;
	public static int showLocationPanel = 1;
	
	public ButtonPanel() {
		buttonPanel = new JPanel(); //button이 있는 panel
				
		buttonPanel.setLayout(null);//panel 정렬
		buttonPanel.setBackground(Color.GRAY);//panel 색상
		buttonPanel.setBounds(0, 0, 150, 770);//panel 사이즈 지정
		
		//new Panel
		miniToolPanel = new Panel(0,0,55,19,Color.WHITE);
		miniColorPanel = new Panel(0,21,55,19, Color.BLACK);
		miniSizePanel = new Panel(65,0,55,40,Color.WHITE);
		statusPanel = new Panel(15,15,120,40, Color.GRAY);
		toolPanel = new Panel(15,140,120,90, Color.GRAY);
		drawPanel = new Panel(15,280,120,90, Color.GRAY);
		colorPanel = new Panel(15,420,120,45, Color.GRAY);
		locationPanel = new Panel(0, 730, 150, 40, Color.WHITE);
		locationPanel.panel.setVisible(true);
		
		//add panel
		buttonPanel.add(statusPanel.panel);
		buttonPanel.add(toolPanel.panel);
		buttonPanel.add(drawPanel.panel);
		buttonPanel.add(colorPanel.panel);
		buttonPanel.add(locationPanel.panel);
		
		//tool panel 정렬
		statusPanel.panel.setLayout(null);
		toolPanel.panel.setLayout(new GridLayout(2,2,5,5));
		drawPanel.panel.setLayout(new GridLayout(2,2,5,5));
		colorPanel.panel.setLayout(new GridLayout(1,2,5,5));
		locationPanel.panel.setLayout(null);
		
		//miniPanel add
		statusPanel.panel.add(miniColorPanel.panel);
		statusPanel.panel.add(miniSizePanel.panel);
		statusPanel.panel.add(miniToolPanel.panel);
		miniSizePanel.panel.setLayout(null);
		miniToolPanel.panel.setLayout(null);
		
		//new Label
		statusLabel = new Label("도구 상태", 0,55,	150,30, Color.WHITE);
		toolLabel = new Label("도구", 0,235,150,30, Color.WHITE);
		drawLabel = new Label("그리기", 0,375,150,30, Color.WHITE);
		colorLabel = new Label("색", 0,470,150,30, Color.WHITE);
		miniSizeLabel = new Label("1", 8,0,40,40, Color.BLACK);
		miniToolLabel = new Label("마우스", 0,0,55,19, Color.BLACK);
		locationLabel = new Label("x  :  0,   y  :  0", 0, -5, 150, 40, Color.BLACK);
		
		//label font
		miniSizeLabel.label.setFont(new Font("Dialog", Font.BOLD, 15));
		miniToolLabel.label.setFont(new Font("Dialog", Font.BOLD, 10));
		
		//add label
		buttonPanel.add(statusLabel.label);
		buttonPanel.add(toolLabel.label);
		buttonPanel.add(drawLabel.label);
		buttonPanel.add(colorLabel.label);
		miniSizePanel.panel.add(miniSizeLabel.label);
		miniToolPanel.panel.add(miniToolLabel.label);
		locationPanel.panel.add(locationLabel.label);
		
		//new Button toolPanel
		for(int i = 0; i<2; i++) toolButton[i] = new Normal(toolTitle[i]);
		toolCombo = new Combo();
		sizeButton = new Size("굵기");
		textButton = new Text("T속성");
		
		//add button toolPanel
		buttonPanel.add(toolCombo.combo);
		toolPanel.panel.add(toolButton[0].button);
		toolPanel.panel.add(sizeButton.size);
		toolPanel.panel.add(toolButton[1].button);
		toolPanel.panel.add(textButton.text);
		
		//new Button drawPanel
		for(int i = 0; i<3; i++) drawButton[i] = new Normal(drawTitle[i]);
		textBoxButton = new TextBox("T박스");
		
		//add Button drawPanel
		for(int i = 0; i<3; i++) drawPanel.panel.add(drawButton[i].button);
		drawPanel.panel.add(textBoxButton.button);
		
		//new Button colorPanel
		colorButton = new BColor("색상표");
		pipetteButton = new Normal("스포이드");
		
		//add Button colorPanel
		colorPanel.panel.add(colorButton.color);
		colorPanel.panel.add(pipetteButton.button);
	}
}
