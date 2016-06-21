package de.navo.noisy.interpolation;

public interface Interpolation {

	public double interpolate(double start, double end, double percent);
	public String getName();
}
