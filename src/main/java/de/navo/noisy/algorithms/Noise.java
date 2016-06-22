package de.navo.noisy.algorithms;

import de.navo.noisy.interpolation.Interpolation;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;
import lombok.Data;

@Data
public abstract class Noise {

	protected int width;
	protected int height;
	
	public Noise(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public abstract void calculate(ExecutorService executor, Interpolation interpolation, Consumer<float[][]> callback);
	public abstract String getName();
	
}
