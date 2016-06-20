package de.navo.noisy.util;

import javax.swing.JOptionPane;

public class OptionPaneBuilder {

	private String title;
	private String message;
	private int type;
	
	public OptionPaneBuilder() {
		this.title = "";
		this.message = "";
		this.type = JOptionPane.INFORMATION_MESSAGE;
	}
	
	public OptionPaneBuilder message(String message) {
		this.message = message; return this;
	}
	
	public OptionPaneBuilder error() {
		this.title = "Noisy - Error";
		this.type = JOptionPane.ERROR_MESSAGE; 
		return this;
	}
	
	public OptionPaneBuilder info() {
		this.title = "Noisy - Information";
		this.type = JOptionPane.INFORMATION_MESSAGE;
		return this;
	}
	
	public void show() {
		JOptionPane.showMessageDialog(null, this.message, this.title, this.type);
	}
	
}
