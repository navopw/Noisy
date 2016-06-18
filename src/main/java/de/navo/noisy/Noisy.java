package de.navo.noisy;

import de.navo.noisy.gui.MainClient;
import de.navo.noisy.util.LookAndFeel;
import java.util.Random;

public class Noisy {

	public static final Random RANDOM = new Random();

	public static void main(String[] args) {
		LookAndFeel.setSystemLookAndFeel();
		
		MainClient client = new MainClient();
		client.start();
	}

}
