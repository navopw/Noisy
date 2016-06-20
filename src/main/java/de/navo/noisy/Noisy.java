package de.navo.noisy;

import de.navo.noisy.gui.MainClient;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Noisy {

	public static final Random RANDOM = new Random();
	public static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();
	public static final String VERSION = "0.9";
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
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
