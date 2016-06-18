package de.navo.noisy.gui;

import de.navo.noisy.algorithms.ValueNoise;
import de.navo.noisy.util.FileChooser;
import de.navo.noisy.util.ImageScale;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainClient extends javax.swing.JFrame {

	private ExecutorService singleThreadExecutor;
	private BufferedImage cachedImage;

	public MainClient() {
		this.initComponents();

		this.singleThreadExecutor = Executors.newSingleThreadExecutor();
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        recalculateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        octavesSlider = new javax.swing.JSlider();
        imagePane = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        resolutionSlider = new javax.swing.JSlider();
        minimumHeightField = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        maximumHeightField = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        exportAsImageButton = new javax.swing.JButton();
        frequencySlider = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        recalculateButton.setText("Recalculate");
        recalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recalculateButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Octaves:");

        octavesSlider.setMaximum(12);
        octavesSlider.setMinimum(1);
        octavesSlider.setValue(5);

        imagePane.setBackground(new java.awt.Color(254, 254, 254));

        jLabel2.setText("Resolution:");

        jLabel4.setText("Frequency:");

        resolutionSlider.setMaximum(4096);
        resolutionSlider.setMinimum(16);
        resolutionSlider.setMinorTickSpacing(16);
        resolutionSlider.setValue(16);

        minimumHeightField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        minimumHeightField.setText("0");

        jLabel5.setText("Minimum height:");

        maximumHeightField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        maximumHeightField.setText("255");

        jLabel6.setText("Maximum height:");

        exportAsImageButton.setText("Export as image");
        exportAsImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportAsImageButtonActionPerformed(evt);
            }
        });

        frequencySlider.setMaximum(50);
        frequencySlider.setMinimum(1);
        frequencySlider.setValue(6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePane, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exportAsImageButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(resolutionSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(recalculateButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(octavesSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(frequencySlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minimumHeightField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maximumHeightField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imagePane, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addComponent(resolutionSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(octavesSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(frequencySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minimumHeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maximumHeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportAsImageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recalculateButton))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recalculateButtonActionPerformed
		this.singleThreadExecutor.execute(() -> {
			this.recalculate();
		});
    }//GEN-LAST:event_recalculateButtonActionPerformed

    private void exportAsImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportAsImageButtonActionPerformed
		FileChooser.open((file) -> {
			if (file == null) return;
			if (this.cachedImage == null) return;
			
			this.exportAsImage(file, (exception) -> {
				if (exception == null) {
					JOptionPane.showMessageDialog(null, "Exported noisemap successfully!", "Noisy - Information", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Failed exporting noisemap!", "Noisy - Error", JOptionPane.ERROR_MESSAGE);
				}
			});
		});
    }//GEN-LAST:event_exportAsImageButtonActionPerformed

	public void start() {
		this.setTitle("Noisy");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		this.recalculate();
	}

	private void recalculate() {
		int resolution = this.resolutionSlider.getValue();
		int octaves = this.octavesSlider.getValue();
		int frequency = this.frequencySlider.getValue();

		ValueNoise noise = new ValueNoise(resolution, resolution);
		noise.setOctaves(octaves);
		noise.setStartFrequencyX(frequency);
		noise.setStartFrequencyY(frequency);

		float[][] noiseMap = noise.calculate();

		this.draw(noiseMap, resolution, resolution);
	}

	private void exportAsImage(File path, Consumer<Exception> callback) {
		try {
			ImageIO.write(this.cachedImage, "png", path);
			callback.accept(null);
		} catch (IOException exception) {
			callback.accept(exception);
		}
	}

	private BufferedImage generateImage(float[][] map, int width, int height) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_USHORT_GRAY);

		int minHeight = Integer.parseInt(this.minimumHeightField.getText());
		int maxHeight = Integer.parseInt(this.maximumHeightField.getText());

		for (int widthIndex = 0; widthIndex < width; widthIndex++) {
			for (int heightIndex = 0; heightIndex < height; heightIndex++) {
				float value = map[widthIndex][heightIndex];
				image.setRGB(widthIndex, heightIndex, this.getGreyScale(value, minHeight, maxHeight));
			}
		}

		return image;
	}

	private void draw(float[][] noiseMap, int width, int height) {
		BufferedImage image = this.generateImage(noiseMap, width, height);

		int originalWidth = image.getWidth();
		int originalHeight = image.getHeight();

		double ratio = (double) originalWidth / (double) originalHeight;
		double scale = 0.99;

		int scaledWidth = (int) (imagePane.getWidth() * scale);
		int scaledHeight = (int) (imagePane.getHeight() / ratio * scale);

		BufferedImage scaledImage = ImageScale.scaleImage(image, scaledWidth, scaledHeight, BufferedImage.TYPE_USHORT_GRAY);
		this.drawOnImagePane(scaledImage);

		if (this.cachedImage != null) {
			this.cachedImage.getGraphics().dispose();
		}
		this.cachedImage = image;
	}

	private void drawOnImagePane(BufferedImage image) {
		this.imagePane.setViewportView(new JLabel(new ImageIcon(image)));
	}

	private int getGreyScale(float noise, int min, int max) {
		int rgb = (int) (((max - min) * noise) + min);
		return new Color(rgb, rgb, rgb).getRGB();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportAsImageButton;
    private javax.swing.JSlider frequencySlider;
    private javax.swing.JScrollPane imagePane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFormattedTextField maximumHeightField;
    private javax.swing.JFormattedTextField minimumHeightField;
    private javax.swing.JSlider octavesSlider;
    private javax.swing.JButton recalculateButton;
    private javax.swing.JSlider resolutionSlider;
    // End of variables declaration//GEN-END:variables
}
