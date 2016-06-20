package de.navo.noisy.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageUtil {

	public static BufferedImage scaleImage(BufferedImage image, int width, int height) {
		BufferedImage resizedImage = new BufferedImage(width, height, image.getType());
		Graphics2D graphics = (Graphics2D) resizedImage.getGraphics();
		graphics.drawImage(image, 0, 0, width, height, null);
		return resizedImage;
	}

	public static void exportAsImage(BufferedImage image, File path, Consumer<Exception> callback) {
		try {
			ImageIO.write(image, "png", path);
			callback.accept(null);
		} catch (IOException exception) {
			callback.accept(exception);
		}
	}

	public static Image iconToImage(Icon icon) {
		return ((ImageIcon) icon).getImage();
	}

}
