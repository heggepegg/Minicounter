package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by SexyRasmus on 2016-02-04.
 */
public class ImageButton extends JButton {
	private Image gunga;

	public ImageButton() throws IOException {
		gunga = ImageIO.read(new File("swing.jpg"));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(gunga, -12, 0, 60, 67, this);
	}
}
