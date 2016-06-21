package de.navo.noisy.algorithms;

import de.navo.noisy.interpolation.Interpolation;
import de.navo.noisy.util.RandomUtil;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;
import lombok.Data;

@Data
public class ValueNoise implements Noise {

	private final int width;
	private final int height;

	private int octaves;
	private int frequency;
	private float alpha;

	public ValueNoise(int width, int height) {
		this.width = width;
		this.height = height;
		this.octaves = 8;
		this.frequency = 2;
		this.alpha = 20;
	}

	/**
	 * 
	 * @param executor
	 * @param callback null when out of memory
	 */
	@Override
	public void calculate(ExecutorService executor, Interpolation interpolation, Consumer<float[][]> callback) {
		executor.execute(() -> {
			try {
				float[][] noiseMap = new float[this.width][this.height];

				int currentFrequencyX = frequency;
				float currentAlpha = alpha;

				for (int currentOctave = 0; currentOctave < octaves; currentOctave++) {
					if (currentOctave > 0) {
						currentFrequencyX *= 2;
						currentAlpha /= 2;
					}

					float[][] discretePoints = new float[currentFrequencyX + 1][currentFrequencyX + 1];
					for (int i = 0; i < currentFrequencyX + 1; i++) {
						for (int k = 0; k < currentFrequencyX + 1; k++) {
							discretePoints[i][k] = RandomUtil.nextFloat(-currentAlpha, currentAlpha);
						}
					}

					for (int i = 0; i < width; i++) {
						for (int k = 0; k < height; k++) {
							float currentX = i / (float) width * currentFrequencyX;
							float currentY = k / (float) height * currentFrequencyX;
							int indexX = (int) currentX;
							int indexY = (int) currentY;

							double weight0 = interpolation.interpolate(
									discretePoints[indexX][indexY],
									discretePoints[indexX + 1][indexY],
									currentX - indexX
							);
							double weight1 = interpolation.interpolate(
									discretePoints[indexX][indexY + 1],
									discretePoints[indexX + 1][indexY + 1],
									currentX - indexX
							);

							double weight = interpolation.interpolate(weight0, weight1, currentY - indexY);
							noiseMap[i][k] += weight;
						}
					}
				}

				//normalize
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

				callback.accept(noiseMap);
			} catch (OutOfMemoryError ex) {
				callback.accept(null);
			}
		});
	}

	@Override
	public String getName() {
		return "Value";
	}

}
