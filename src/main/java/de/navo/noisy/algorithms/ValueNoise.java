package de.navo.noisy.algorithms;

import de.navo.noisy.Noisy;
import de.navo.noisy.interpolation.BiCubicInterpolation;
import de.navo.noisy.interpolation.Interpolation;
import de.navo.noisy.util.MathUtil;
import de.navo.noisy.util.RandomUtil;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ValueNoise extends Noise {

	private int octaves;
	private int frequency;
	private float alpha = 16;

	public ValueNoise(int width, int height) {
		super(width, height);
	}

	public ValueNoise octaves(int octaves) {
		this.octaves = octaves;
		return this;
	}

	public ValueNoise frequency(int frequency) {
		this.frequency = frequency;
		return this;
	}

	/**
	 *
	 * @param executor
	 * @param interpolation
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

					float[][] discretePoints = new float[currentFrequencyX + 3][currentFrequencyX + 3];
					for (int i = 0; i < currentFrequencyX + 3; i++) {
						for (int k = 0; k < currentFrequencyX + 3; k++) {
							discretePoints[i][k] = RandomUtil.nextFloat(-currentAlpha, currentAlpha);
						}
					}

					for (int i = 0; i < width; i++) {
						for (int k = 0; k < height; k++) {
							float currentX = i / (float) width * currentFrequencyX;
							float currentY = k / (float) height * currentFrequencyX;
							int indexX = (int) currentX;
							int indexY = (int) currentY;

							switch (interpolation.getName()) {
								case "BiCubic":
									BiCubicInterpolation biCubic = (BiCubicInterpolation) interpolation;
									double preWeight = biCubic.interpolateCubic(
											discretePoints[indexX][indexY],
											discretePoints[indexX + 1][indexY],
											discretePoints[indexX + 2][indexY],
											discretePoints[indexX + 3][indexY],
											currentX - indexX
									);
									double startWeight = biCubic.interpolateCubic(
											discretePoints[indexX][indexY + 1],
											discretePoints[indexX + 1][indexY + 1],
											discretePoints[indexX + 2][indexY + 1],
											discretePoints[indexX + 3][indexY + 1],
											currentX - indexX
									);
									double endWeight = biCubic.interpolateCubic(
											discretePoints[indexX][indexY + 2],
											discretePoints[indexX + 1][indexY + 2],
											discretePoints[indexX + 2][indexY + 2],
											discretePoints[indexX + 3][indexY + 2],
											currentX - indexX
									);
									double postWeight = biCubic.interpolateCubic(
											discretePoints[indexX][indexY + 3],
											discretePoints[indexX + 1][indexY + 3],
											discretePoints[indexX + 2][indexY + 3],
											discretePoints[indexX + 3][indexY + 3],
											currentX - indexX
									);
									
									double finalWeight = biCubic.interpolateCubic(preWeight, startWeight, endWeight, postWeight, currentY - indexY);
									noiseMap[i][k] *= finalWeight;
									break;
								default:
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
									break;
							}
						}
					}

					discretePoints = null;
				}

				//normalize
				noiseMap = MathUtil.normalize(noiseMap, width, height);

				callback.accept(noiseMap);
			} catch (OutOfMemoryError ex) {
				callback.accept(null);
			}
		});
	}

	@Override
	public String getName() {
		return "ValueNoise";
	}

}
