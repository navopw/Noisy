package de.navo.noisy.algorithms;

import de.navo.noisy.Noisy;
import de.navo.noisy.util.Interpolation;
import lombok.Data;

@Data
public class ValueNoise {

	private final int width;
	private final int height;

	private int octaves;
	private int startFrequencyX;
	private int startFrequencyY;
	private float alpha;

	public ValueNoise(int width, int height) {
		this.width = width;
		this.height = height;
		this.octaves = 8;
		this.startFrequencyX = 2;
		this.startFrequencyY = 2;
		this.alpha = 20;
	}

	public float[][] calculate() {
		float[][] map = new float[width][height];

		int currentFrequencyX = startFrequencyX;
		int currentFrequencyY = startFrequencyY;
		float currentAlpha = alpha;

		for (int currentOctave = 0; currentOctave < octaves; currentOctave++) {
			if (currentOctave > 0) {
				currentFrequencyX *= 2;
				currentFrequencyY *= 2;
				currentAlpha /= 2;
			}

			float[][] discretePoints = new float[currentFrequencyX + 1][currentFrequencyY + 1];
			for (int i = 0; i < currentFrequencyX + 1; i++) {
				for (int k = 0; k < currentFrequencyX + 1; k++) {
					discretePoints[i][k] = nextFloat(-currentAlpha, currentAlpha);
				}
			}

			for (int i = 0; i < width; i++) {
				for (int k = 0; k < height; k++) {
					float currentX = i / (float) width * currentFrequencyX;
					float currentY = k / (float) height * currentFrequencyY;
					int indexX = (int) currentX;
					int indexY = (int) currentY;

					double weight0 = Interpolation.cosineInterpolate(
							discretePoints[indexX][indexY],
							discretePoints[indexX + 1][indexY],
							currentX - indexX
					);
					double weight1 = Interpolation.cosineInterpolate(
							discretePoints[indexX][indexY + 1],
							discretePoints[indexX + 1][indexY + 1],
							currentX - indexX
					);

					double weight = Interpolation.cosineInterpolate(weight0, weight1, currentY - indexY);
					map[i][k] += weight;
				}
			}
		}

		//normalize
		float min = Float.MAX_VALUE;
		for (int i = 0; i < width; i++) {
			for (int k = 0; k < height; k++) {
				if (map[i][k] < min) {
					min = map[i][k];
				}
			}
		}
		for (int i = 0; i < width; i++) {
			for (int k = 0; k < height; k++) {
				map[i][k] -= min;
			}
		}

		float max = Float.MIN_VALUE;
		for (int i = 0; i < width; i++) {
			for (int k = 0; k < height; k++) {
				if (map[i][k] > max) {
					max = map[i][k];
				}
			}
		}
		for (int i = 0; i < width; i++) {
			for (int k = 0; k < height; k++) {
				map[i][k] /= max;
			}
		}

		return map;
	}

	private float nextFloat(float min, float max) {
		return min + Noisy.RANDOM.nextFloat() * (max - min);
	}

}
