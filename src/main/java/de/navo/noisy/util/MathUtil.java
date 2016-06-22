package de.navo.noisy.util;

public class MathUtil {

	public static float[][] normalize(float[][] noiseMap, int width, int height) {
		float min = Float.MAX_VALUE;
		for (int i = 0; i < width; i++) {
			for (int k = 0; k < height; k++) {
				if (noiseMap[i][k] < min) {
					min = noiseMap[i][k];
				}
			}
		}
		for (int i = 0; i < width; i++) {
			for (int k = 0; k < height; k++) {
				noiseMap[i][k] -= min;
			}
		}

		float max = Float.MIN_VALUE;
		for (int i = 0; i < width; i++) {
			for (int k = 0; k < height; k++) {
				if (noiseMap[i][k] > max) {
					max = noiseMap[i][k];
				}
			}
		}
		for (int i = 0; i < width; i++) {
			for (int k = 0; k < height; k++) {
				noiseMap[i][k] /= max;
			}
		}
		
		return noiseMap;
	}

	public static double clamp(double value, double min, double max) {
		return (value < min) ? min : (value > max) ? max : value;
	}

}
