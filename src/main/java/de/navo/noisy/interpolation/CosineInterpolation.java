package de.navo.noisy.interpolation;

public class CosineInterpolation implements Interpolation {

	@Override
	public double interpolate(double start, double end, double percent) {
		double mu = (1 - Math.cos(percent * Math.PI)) / 2;
		return start * (1 - mu) + end * mu;
	}

	@Override
	public String getName() {
		return "Cosine";
	}

}
