package de.navo.noisy;

import de.navo.noisy.gui.MainClient;
import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Noisy {

	public static final Random RANDOM = new Random();
	public static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();
	public static final String VERSION = "0.9";
	public static Image ICON;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}
		
		try {
			ICON = ImageIO.read(NoisyResources.ICON.getAsStream());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		MainClient client = new MainClient();
		client.start();
	}

	public static void log(String string) {
		SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss]");
		System.out.println(format.format(new Date()) + " " + string);
	}
	
}
