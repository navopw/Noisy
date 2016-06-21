package de.navo.noisy;

import java.io.InputStream;
import java.net.URL;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NoisyResources {
	ICON("/icon.png"),
	CALCULATING_IMAGE("/calculating.png");

	private String path;

	public URL getAsUrl() {
		return this.getClass().getResource(this.path);
	}

	public InputStream getAsStream() {
		return this.getClass().getResourceAsStream(this.path);
	}
}
