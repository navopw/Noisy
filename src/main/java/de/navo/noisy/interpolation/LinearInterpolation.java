package de.navo.noisy.interpolation;

public class LinearInterpolation implements Interpolation {

	@Override
	public double interpolate(double start, double end, double percent) {
		return start + percent * (end - start);
	}

	@Override
	public String getName() {
		return "Linear";
	}

}
