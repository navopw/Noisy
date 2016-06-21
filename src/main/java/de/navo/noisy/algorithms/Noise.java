package de.navo.noisy.algorithms;

import de.navo.noisy.interpolation.Interpolation;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

public interface Noise {

	public void calculate(ExecutorService executor, Interpolation interpolation, Consumer<float[][]> callback);
	public String getName();
	
}
