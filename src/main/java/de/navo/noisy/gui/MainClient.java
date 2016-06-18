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
        minimumHeightField = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        maximumHeightField = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        exportAsImageButton = new javax.swing.JButton();
        frequencySlider = new javax.swing.JSlider();
        resolutionField = new javax.swing.JFormattedTextField();
        resolutionPlusButton = new javax.swing.JButton();
        resolutionMinusButton = new javax.swing.JButton();
        minimumHeightPlusButton = new javax.swing.JButton();
        minimumHeightMinusButton = new javax.swing.JButton();
        maximumHeightPlusButton = new javax.swing.JButton();
        maximumHeightMinusButton = new javax.swing.JButton();

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

        minimumHeightField.setEditable(false);
        minimumHeightField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        minimumHeightField.setText("0");
        minimumHeightField.setVerifyInputWhenFocusTarget(false);

        jLabel5.setText("Minimum height:");

        maximumHeightField.setEditable(false);
        maximumHeightField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        maximumHeightField.setText("255");
        maximumHeightField.setVerifyInputWhenFocusTarget(false);

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

        resolutionField.setEditable(false);
        resolutionField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        resolutionField.setText("256");
        resolutionField.setVerifyInputWhenFocusTarget(false);

        resolutionPlusButton.setText("+");
        resolutionPlusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resolutionPlusButtonActionPerformed(evt);
            }
        });

        resolutionMinusButton.setText("-");
        resolutionMinusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resolutionMinusButtonActionPerformed(evt);
            }
        });

        minimumHeightPlusButton.setText("+");
        minimumHeightPlusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimumHeightPlusButtonActionPerformed(evt);
            }
        });

        minimumHeightMinusButton.setText("-");
        minimumHeightMinusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimumHeightMinusButtonActionPerformed(evt);
            }
        });

        maximumHeightPlusButton.setText("+");
        maximumHeightPlusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maximumHeightPlusButtonActionPerformed(evt);
            }
        });

        maximumHeightMinusButton.setText("-");
        maximumHeightMinusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maximumHeightMinusButtonActionPerformed(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(minimumHeightField)
                            .addComponent(maximumHeightField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(minimumHeightPlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(minimumHeightMinusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(maximumHeightPlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(maximumHeightMinusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(resolutionField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resolutionPlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(resolutionMinusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(exportAsImageButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(recalculateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(octavesSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(frequencySlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imagePane, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resolutionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resolutionPlusButton)
                            .addComponent(resolutionMinusButton))
                        .addGap(14, 14, 14)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(minimumHeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(minimumHeightPlusButton)
                                .addComponent(minimumHeightMinusButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maximumHeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(maximumHeightPlusButton)
                                .addComponent(maximumHeightMinusButton)))
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

    private void resolutionPlusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resolutionPlusButtonActionPerformed
		int step = 128;
		int field = Integer.parseInt(this.resolutionField.getText());
		
		if ((field + step) <= 2048) {
			this.resolutionField.setValue(field + step);
		}
    }//GEN-LAST:event_resolutionPlusButtonActionPerformed

    private void resolutionMinusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resolutionMinusButtonActionPerformed
		int step = 128;
		int field = Integer.parseInt(this.resolutionField.getText());
		
		if ((field - step) >= 16) {
			this.resolutionField.setValue(field - step);
		}
    }//GEN-LAST:event_resolutionMinusButtonActionPerformed

    private void minimumHeightPlusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimumHeightPlusButtonActionPerformed
		int step = 5;
		int field = Integer.parseInt(this.minimumHeightField.getText());
		
		if ((field + step) <= 255) {
			this.minimumHeightField.setValue(field + step);
		}
    }//GEN-LAST:event_minimumHeightPlusButtonActionPerformed

    private void minimumHeightMinusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimumHeightMinusButtonActionPerformed
		int step = 5;
		int field = Integer.parseInt(this.minimumHeightField.getText());
		
		if ((field - step) >= 0) {
			this.minimumHeightField.setValue(field - step);
		}
    }//GEN-LAST:event_minimumHeightMinusButtonActionPerformed

    private void maximumHeightPlusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maximumHeightPlusButtonActionPerformed
		int step = 5;
		int field = Integer.parseInt(this.maximumHeightField.getText());
		
		if ((field + step) <= 255) {
			this.maximumHeightField.setValue(field + step);
		}
    }//GEN-LAST:event_maximumHeightPlusButtonActionPerformed

    private void maximumHeightMinusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maximumHeightMinusButtonActionPerformed
		int step = 5;
		int field = Integer.parseInt(this.maximumHeightField.getText());
		
		if ((field - step) >= 0) {
			this.maximumHeightField.setValue(field - step);
		}
    }//GEN-LAST:event_maximumHeightMinusButtonActionPerformed

	public void start() {
		this.setTitle("Noisy");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		this.imagePane.requestFocus();
		
		this.recalculate();
	}

	private void recalculate() {
		int resolution = Integer.parseInt(this.resolutionField.getText());
		int octaves = this.octavesSlider.getValue();
		int frequency = this.frequencySlider.getValue();

		ValueNoise noise = new ValueNoise(resolution, resolution);
		noise.setOctaves(octaves);
		noise.setStartFrequencyX(frequency);
		noise.setStartFrequencyY(frequency);

		this.draw(noise.calculate(), resolution, resolution);
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
    private javax.swing.JButton maximumHeightMinusButton;
    private javax.swing.JButton maximumHeightPlusButton;
    private javax.swing.JFormattedTextField minimumHeightField;
    private javax.swing.JButton minimumHeightMinusButton;
    private javax.swing.JButton minimumHeightPlusButton;
    private javax.swing.JSlider octavesSlider;
    private javax.swing.JButton recalculateButton;
    private javax.swing.JFormattedTextField resolutionField;
    private javax.swing.JButton resolutionMinusButton;
    private javax.swing.JButton resolutionPlusButton;
    // End of variables declaration//GEN-END:variables
}
