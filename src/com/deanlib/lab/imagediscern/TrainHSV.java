package com.deanlib.lab.imagediscern;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class TrainHSV {
	
	public static int[] vessel = new int[360];
	public static int[] vesselIndex = new int[360];
	
	public static void main(String[] args) throws IOException {
		File file = new File("D:\\ÅàÑø²ÄÁÏ");
		
		File[] listFiles = file.listFiles();
		//ArrayList<HSV> list = new ArrayList<HSV>();
		for (int i = 0; i < listFiles.length; i++) {
			transition(listFiles[i]);
		}
		
		for (int i = 0; i < vesselIndex.length; i++) {
			vesselIndex[i] = i;
		}
		for (int i = 0; i < vessel.length; i++) {
			for (int j = i+1; j < vessel.length; j++) {
				if(vessel[i]<vessel[j]){
					int temp = vessel[i];
					vessel[i] = vessel[j];
					vessel[j] = temp;
					int tempIndex = vesselIndex[i];
					vesselIndex[i] = vesselIndex[j];
					vesselIndex[j] = tempIndex;
				}
			}
		}
		for (int i = 0; i < vesselIndex.length; i++) {
			System.out.println("H="+vesselIndex[i]+",count:"+vessel[i]);
		}
	}
	
	private static ArrayList<HSV> transition(File file) throws IOException{
		System.out.println(file.getName());
		BufferedImage img = ImageIO.read(file);
		ArrayList<HSV> list = new ArrayList<HSV>();
		for (int j = 0; j <img.getWidth(); j++) {
			for (int j2 = 0; j2 < img.getHeight(); j2++) {
				int binaryColor = img.getRGB(j, j2);
				if(binaryColor==16777215) continue;
				Color c = new Color(binaryColor);
				RGB rgb = new RGB(c.getRed(), c.getGreen(), c.getBlue());
				HSV hsv = ColorUtils.RGB2HSV(rgb);
				if(!"NaN".equals(String.valueOf(hsv.getH())))
					vessel[(int)hsv.getH()]++;
				list.add(hsv);
				System.out.println(hsv);
			}
			
		}
		return list;
	}

}

