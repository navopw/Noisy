package de.navo.noisy.util;

import de.navo.noisy.Noisy;

public class RandomUtil {

	public static float nextFloat(float min, float max) {
		return min + Noisy.RANDOM.nextFloat() * (max - min);
	}
	
}
