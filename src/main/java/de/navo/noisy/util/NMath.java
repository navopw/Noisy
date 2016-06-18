package de.navo.noisy.util;

public class NMath {

	public static double normalize(double value, double min, double max) {
		return (value - min) / (max - min);
	}

	public static double clamp(double value, double min, double max) {
		return (value < min) ? min : (value > max) ? max : value;
	}
	
	public static double navo(double value, double valueMin, double valueMax, double min, double max) {
		double mid = Interpolation.linearInterpolate(value, valueMin, valueMax);
		double percent = valueMax / mid;
		
		double endValue = percent * max;
		
		return clamp(endValue, min, max);
	}

}
