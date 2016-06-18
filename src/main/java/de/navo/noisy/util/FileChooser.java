package de.navo.noisy.util;

import java.awt.EventQueue;
import java.io.File;
import java.util.function.Consumer;
import javax.swing.JFileChooser;

public class FileChooser {

	/**
	 * The shortest way to handle a file selection with Java 8
	 * @param callback A callback with the chosen file, null when aborted selecting.
	 */
	public static void open(Consumer<File> callback) {
		EventQueue.invokeLater(() -> {
			JFileChooser filechooser = new JFileChooser();
			
			if (filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				callback.accept(filechooser.getSelectedFile());
			} else {
				callback.accept(null);
			}
		});
	}
	
}