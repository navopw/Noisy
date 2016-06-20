package de.navo.noisy.algorithms;

import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

public interface Noise {

	public void calculate(ExecutorService executor, Consumer<float[][]> callback);
	
}
