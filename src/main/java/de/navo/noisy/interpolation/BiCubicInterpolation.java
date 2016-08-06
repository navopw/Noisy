package de.navo.noisy.interpolation;

public class BiCubicInterpolation implements Interpolation {

	@Override
	public double interpolate(double start, double end, double percent) {
		return 0;
	}
	
	public double interpolateCubic(double preStart, double start, double end, double postEnd, double percent) {
		//return (-0.5 * preStart + 3/2 * start - 3/2 * end + 0.5 * postEnd) * Math.pow(percent, 3) + (preStart - 5/2 * start + 2 * end -0.5 * postEnd) * Math.pow(percent, 2) + (-0.5 * preStart + 0.5 * end) * percent + start;
		return (postEnd + end - preStart + start) * Math.pow(percent, 3)
				+ (2 * preStart - 2 * start + postEnd + end) * Math.pow(percent, 2)
				+ (end - preStart) * percent + start;
	}

	@Override
	public String getName() {
		return "BiCubic (not working)";
	}
	
}
