package GraphicEditor;

import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

public class Save implements ActionListener{
	MainPanel panel;
	BufferedImage bufferedImage;
	JFileChooser jFileChooser;

	Save(MainPanel panel, BufferedImage bufferedImage) {
		this.panel = panel;
		this.bufferedImage = bufferedImage;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		jFileChooser = new JFileChooser();
		jFileChooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
		int rVal = jFileChooser.showSaveDialog(null);
		if (rVal == JFileChooser.APPROVE_OPTION) {
			File file = jFileChooser.getSelectedFile();
			try {
				ImageIO.write(bufferedImage, "png", new File(file.getAbsolutePath()));
				System.out.println("saved Correctly " + file.getAbsolutePath());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Failed to save image");
			}
		}
		if (rVal == JFileChooser.CANCEL_OPTION) {
			System.out.println("No file choosen");
		}

	}

}
