package de.navo.noisy.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageScale {

	public static BufferedImage scaleImage(BufferedImage image, int width, int height, int type) {
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D graphics = (Graphics2D) resizedImage.getGraphics();
		graphics.drawImage(image, 0, 0, width, height, null);
		return resizedImage;
	}
	
}
