package de.navo.noisy.util;

public class NMath {

	public static double normalize(double value, double min, double max) {
		return (value - min) / (max - min);
	}

	public static double clamp(double value, double min, double max) {
		return (value < min) ? min : (value > max) ? max : value;
	}

}
