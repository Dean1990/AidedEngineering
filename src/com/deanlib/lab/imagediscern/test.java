package com.deanlib.lab.imagediscern;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;


public class test {

	public static final int standardScale = 10;
	public static final int minScale = 5;
	public static final int minRect = 90000;

	public static int renameCount = 0;
	public static int renameSuccess = 0;

	public static void main(String[] args) {
		File file = new File(
				"D:\\IMAGE\\jandan.net");
		check(file);
		System.out.println("C:" + renameCount);
		System.out.println("S:" + renameCount);
	}

	public static void check(File file) {
		File[] listFiles = file.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			if (listFiles[i].isDirectory())
				check(listFiles[i]);
			else if (listFiles[i].getName().endsWith(".jpg")
					|| listFiles[i].getName().endsWith(".png"))
				checkImage(listFiles[i]);
		}
	}

	public static void checkImage(File file) {
		try {
			BufferedImage src = ImageIO.read(new FileInputStream(file));

			if (src == null)
				return;
			int count = 0;
//			 BufferedImage dst = new BufferedImage(src.getWidth(),
//			 src.getHeight(),
//			 BufferedImage.TYPE_INT_RGB);
			for (int x = 0; x < src.getWidth(); x++) {
				for (int y = 0; y < src.getHeight(); y++) {
					Color c = new Color(src.getRGB(x, y));
					if (FilterUtils.isFlesh(c)) {
						count++;
						// dst.setRGB(x, y, Color.WHITE.getRGB());
					} else if (FilterUtils.isWB(c)) {
						// dst.setRGB(x, y, Color.BLACK.getRGB());
					}
				}
			}
			// ImageIO.write(dst, "jpg",
			 //new File(file.getParent() + "/deal_" + file.getName()));
			int scale = (int) ((float) count
					/ (src.getWidth() * src.getHeight()) * 100);
			System.out.println(file.getName() + " " + scale + "%");
			if (scale < standardScale
					&& (scale < minScale || (src.getWidth() * src.getHeight()) < minRect)) {
				renameCount++;
				System.gc();
				boolean b = file.renameTo(new File(file.getParent()
						+ "/zzz_del_" + file.getName()));
				if (b)
					renameSuccess++;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
