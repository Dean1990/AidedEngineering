package com.deanlib.lab.imagediscern;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UnTrainHSV {

	public static void main(String[] args) throws IOException {
		BufferedImage dst = new BufferedImage(100, 360 * 5,
				BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < 100; i++) {
			//for (int j = 0; j < 360 * 5; j++) {
			for (int j = 0; j < 50 * 5; j++) {
				dst.setRGB(i, j, ColorUtils.RGB2Binary(ColorUtils.HSV2RGB(new HSV(j/5, (float)0.5, (float)0.5))));
			}
		}
		ImageIO.write(dst, "jpg", new File("D:\\hsv1.jpg"));
	}

}
