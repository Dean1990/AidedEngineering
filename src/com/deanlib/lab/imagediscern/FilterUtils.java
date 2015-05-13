package com.deanlib.lab.imagediscern;

import java.awt.Color;

import org.loon.framework.image.filtrate.LDialyzer;

public class FilterUtils {
	
	/**
	 * flesh
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isFlesh(final Color c) {
		if ((c.getRed() > 230) && (c.getGreen() > 170) && (c.getBlue() > 190)) {
			return false;
		}
		LDialyzer yuv = LDialyzer.getYuv(c.getRed(), c.getGreen(), c.getBlue());
		return ((c.getRed() > 40) && (c.getGreen() > 40) && (yuv.y + 16 > 145)
				&& (yuv.v + 128 < 173) && (yuv.v + 128 > 133)
				&& (yuv.u + 128 < 127) && (yuv.u + 128 > 77));
	}
	
	public static boolean isWB(Color c){
		return false;
	}
	
	public static boolean isFlesh2(Color c){
		RGB rgb = new RGB(c.getRed(),c.getGreen(),c.getBlue());
		HSV hsv = ColorUtils.RGB2HSV(rgb);
		if(hsv.getH()>9&&hsv.getH()<43){
			return true;
		}
		return false;
	}

}
