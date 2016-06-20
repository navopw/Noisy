package de.navo.noisy.gui;

import de.navo.noisy.Noisy;
import de.navo.noisy.NoisyResources;
import de.navo.noisy.algorithms.ValueNoise;
import de.navo.noisy.util.FileChooser;
import de.navo.noisy.util.ImageUtil;
import de.navo.noisy.util.OptionPaneBuilder;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainClient extends JFrame {

	private boolean calculating;
	private BufferedImage cachedImage;

	public MainClient() {
		this.initComponents();
		this.calculating = false;
	}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        recalculateButton = new javax.swing.JButton();
        octavesLabel = new javax.swing.JLabel();
        octavesSlider = new javax.swing.JSlider();
        imagePane = new javax.swing.JScrollPane();
        resolutionLabel = new javax.swing.JLabel();
        frequencyLabel = new javax.swing.JLabel();
        minimumHeightField = new javax.swing.JFormattedTextField();
        minimumHeightLabel = new javax.swing.JLabel();
        maximumHeightField = new javax.swing.JFormattedTextField();
        maximumHeightLabel = new javax.swing.JLabel();
        exportAsImageButton = new javax.swing.JButton();
        frequencySlider = new javax.swing.JSlider();
        resolutionField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        recalculateButton.setText("Recalculate");
        recalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recalculateButtonActionPerformed(evt);
            }
        });

        octavesLabel.setText("Octaves:");

        octavesSlider.setMaximum(10);
        octavesSlider.setMinimum(1);
        octavesSlider.setPaintLabels(true);
        octavesSlider.setPaintTicks(true);
        octavesSlider.setSnapToTicks(true);
        octavesSlider.setValue(5);

        imagePane.setBackground(new java.awt.Color(254, 254, 254));

        resolutionLabel.setText("Resolution:");

        frequencyLabel.setText("Frequency:");

        minimumHeightField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        minimumHeightField.setText("0");
        minimumHeightField.setVerifyInputWhenFocusTarget(false);

        minimumHeightLabel.setText("Minimum height:");

        maximumHeightField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        maximumHeightField.setText("255");
        maximumHeightField.setVerifyInputWhenFocusTarget(false);

        maximumHeightLabel.setText("Maximum height:");

        exportAsImageButton.setText("Export as image");
        exportAsImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportAsImageButtonActionPerformed(evt);
            }
        });

        frequencySlider.setMaximum(50);
        frequencySlider.setMinimum(1);
        frequencySlider.setPaintLabels(true);
        frequencySlider.setPaintTicks(true);
        frequencySlider.setSnapToTicks(true);
        frequencySlider.setValue(4);

        resolutionField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        resolutionField.setText("256");
        resolutionField.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePane, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maximumHeightField)
                    .addComponent(minimumHeightField)
                    .addComponent(resolutionField)
                    .addComponent(frequencySlider, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(octavesSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(recalculateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exportAsImageButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resolutionLabel)
                            .addComponent(frequencyLabel)
                            .addComponent(minimumHeightLabel)
                            .addComponent(maximumHeightLabel)
                            .addComponent(octavesLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imagePane, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(resolutionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resolutionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(octavesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(octavesSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(frequencyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(frequencySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minimumHeightLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minimumHeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maximumHeightLabel)
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
		this.recalculate();

		this.imagePane.requestFocus(); //Unfocus button
    }//GEN-LAST:event_recalculateButtonActionPerformed

    private void exportAsImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportAsImageButtonActionPerformed
		if (this.cachedImage == null) {
			return;
		}

		FileChooser.open((file) -> {
			if (file != null) {
				ImageUtil.exportAsImage(this.cachedImage, file, (exception) -> {
					if (exception == null) {
						new OptionPaneBuilder().info().message("Exported noisemap successfully!").show();
					} else {
						new OptionPaneBuilder().info().message("Failed exporting noisemap!").show();
					}
				});
			}
		});

		this.imagePane.requestFocus(); //Unfocus button
    }//GEN-LAST:event_exportAsImageButtonActionPerformed

	public void start() {
		this.setTitle("Noisy - " + Noisy.VERSION);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		this.recalculateButton.doClick();
	}

	private void recalculate() {
		int resolution = this.getResolution();
		int octaves = this.getOctaves();
		int frequency = this.getFrequency();
		int minHeight = this.getMinimumHeight();
		int maxHeight = this.getMaximumHeight();

		if (resolution < 16) {
			new OptionPaneBuilder().error().message("The resolution should be bigger or equal 16!").show();
			this.resolutionField.setText("512");
			return;
		}

		if (resolution > 2048) {
			new OptionPaneBuilder().error().message("A high resolution could crash Noisy! (Use 16 - 2048)").show();
			this.resolutionField.setText("512");
			return;
		}

		if (minHeight > maxHeight) {
			new OptionPaneBuilder().error().message("Minimum height can't be bigger than maximum height!").show();
			return;
		}

		if (minHeight < 0) {
			new OptionPaneBuilder().error().message("Minimum height can't ne negative!").show();
			return;
		}

		if (maxHeight > 255) {
			new OptionPaneBuilder().error().message("Maximum height has to be smaller or equal to 255!").show();
			return;
		}

		if (this.calculating) {
			return;
		}
		
		//Calculating...
		this.drawCalculatingScreen();

		ValueNoise noise = new ValueNoise(resolution, resolution);
		noise.setOctaves(octaves);
		noise.setFrequency(frequency);

		this.calculating = true;
		noise.calculate(Noisy.EXECUTOR, (noiseMap) -> {
			if (noiseMap != null) {
				this.drawNoiseMap(noiseMap);
			} else {
				new OptionPaneBuilder().error().message("Your memory can't handle generating a noise-map that big!").show();
			}
			this.calculating = false;
		});
	}

	private void drawNoiseMap(float[][] noiseMap) {
		int minHeight = this.getMinimumHeight();
		int maxHeight = this.getMaximumHeight();
		int width = noiseMap.length;
		int height = noiseMap[0].length;

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_USHORT_GRAY);

		for (int widthIndex = 0; widthIndex < width; widthIndex++) {
			for (int heightIndex = 0; heightIndex < height; heightIndex++) {
				float value = noiseMap[widthIndex][heightIndex];
				image.setRGB(widthIndex, heightIndex, this.getGreyScale(value, minHeight, maxHeight));
			}
		}

		this.drawImage(image);

		if (this.cachedImage != null) {
			this.cachedImage.getGraphics().dispose();
		}
		this.cachedImage = image;
	}

	private void drawCalculatingScreen() {
		try {
			ImageIcon icon = new ImageIcon(ImageIO.read(NoisyResources.CALCULATING_IMAGE.getAsStream()));
			BufferedImage image = (BufferedImage) icon.getImage();
			this.drawImage(image);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private void drawImage(BufferedImage image) {
		final double scale = 0.99;
		int originalWidth = image.getWidth();
		int originalHeight = image.getHeight();

		double ratio = (double) originalWidth / (double) originalHeight;
		int scaledWidth = (int) (imagePane.getWidth() * scale);
		int scaledHeight = (int) (imagePane.getHeight() / ratio * scale);

		BufferedImage scaledImage = ImageUtil.scaleImage(image, scaledWidth, scaledHeight);
		this.imagePane.setViewportView(new JLabel(new ImageIcon(scaledImage)));

		image.getGraphics().dispose();
	}

	private int getGreyScale(float noise, int min, int max) {
		int greyScale = (int) (((max - min) * noise) + min);

		return new Color(greyScale, greyScale, greyScale).getRGB();
	}

	public int getResolution() {
		return Integer.parseInt(this.resolutionField.getText());
	}

	public int getOctaves() {
		return this.octavesSlider.getValue();
	}

	public int getFrequency() {
		return this.frequencySlider.getValue();
	}

	public int getMinimumHeight() {
		return Integer.parseInt(this.minimumHeightField.getText());
	}

	public int getMaximumHeight() {
		return Integer.parseInt(this.maximumHeightField.getText());
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportAsImageButton;
    private javax.swing.JLabel frequencyLabel;
    private javax.swing.JSlider frequencySlider;
    private javax.swing.JScrollPane imagePane;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFormattedTextField maximumHeightField;
    private javax.swing.JLabel maximumHeightLabel;
    private javax.swing.JFormattedTextField minimumHeightField;
    private javax.swing.JLabel minimumHeightLabel;
    private javax.swing.JLabel octavesLabel;
    private javax.swing.JSlider octavesSlider;
    private javax.swing.JButton recalculateButton;
    private javax.swing.JFormattedTextField resolutionField;
    private javax.swing.JLabel resolutionLabel;
    // End of variables declaration//GEN-END:variables
}
