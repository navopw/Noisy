package de.navo.noisy;

import de.navo.noisy.algorithms.Noise;
import de.navo.noisy.algorithms.PerlinNoise;
import de.navo.noisy.algorithms.ValueNoise;
import de.navo.noisy.gui.MainClient;
import de.navo.noisy.interpolation.BiCubicInterpolation;
import de.navo.noisy.interpolation.CosineInterpolation;
import de.navo.noisy.interpolation.Interpolation;
import de.navo.noisy.interpolation.LinearInterpolation;
import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Noisy {

	public static final Random RANDOM = new Random();
	public static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();
	public static final String VERSION = "1.0";
	public static Image ICON;
	
	public static final Map<String, Noise> NOISES = new HashMap<>();
	public static final Map<String, Interpolation> INTERPOLATIONS = new HashMap<>();
	
	static {
		Noisy.addInterpolation(new LinearInterpolation());
		Noisy.addInterpolation(new CosineInterpolation());
		Noisy.addInterpolation(new BiCubicInterpolation());
		
		Noisy.addNoiseAlgorithm(new ValueNoise(0, 0));
		Noisy.addNoiseAlgorithm(new PerlinNoise(0, 0));
	}
	
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
	
	private static void addInterpolation(Interpolation interpolation) {
		INTERPOLATIONS.put(interpolation.getName(), interpolation);
	}
	
	private static void addNoiseAlgorithm(Noise noise) {
		NOISES.put(noise.getName(), noise);
	}
	
}
