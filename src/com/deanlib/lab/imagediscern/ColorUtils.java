package com.deanlib.lab.imagediscern;

public class ColorUtils {

	public static HSV RGB2HSV(RGB rgb) {
		float r = (float) rgb.getR() / 255;
		float g = (float) rgb.getG() / 255;
		float b = (float) rgb.getB() / 255;
		float max = max(r, g, b);
		float min = min(r, g, b);
		float h = 0;
		if (r == max)
			h = (g - b) / (max - min);
		if (g == max)
			h = 2 + (b - r) / (max - min);
		if (b == max)
			h = 4 + (r - g) / (max - min);
		h *= 60;
		if (h < 0)
			h += 360;
		HSV hsv = new HSV(h, (max - min) / max, max);
		return hsv;
	}

	public static RGB HSV2RGB(HSV hsv) {
		float r=0, g=0, b=0, h = hsv.getH(), f, a, d, c;
		if (hsv.getS() == 0)
			r = g = b = hsv.getV();
		else {
			h /= 60;
			int i = (int) h;
			f = h - i;
			a = hsv.getV() * (1 - hsv.getS());
			d = hsv.getV() * (1 - hsv.getS() * f);
			c = hsv.getV() * (1 - hsv.getS() * (1 - f));
			switch (i) {
			case 0:
				r = hsv.getV();
				g = c;
				b = a;
				break;
			case 1:
				r = d;
				g = hsv.getV();
				b = a;
				break;
			case 2:
				r = a;
				g = hsv.getV();
				b = c;
				break;
			case 3:
				r = a;
				g = d;
				b = hsv.getV();
				break;
			case 4:
				r = c;
				g = a;
				b = hsv.getV();
				break;
			case 5:
				r = hsv.getV();
				g = a;
				b = d;
				break;

			default:
				break;
			}
		}
		r*=255;
		g*=255;
		b*=255;
		return new RGB((int)r,(int)g,(int)b);
	}

	public static RGB binary2RGB(int b) {
		return new RGB((b & 0xff0000) >> 16, (b & 0xff00) >> 8, b & 0xff);
	}
	
	public static int RGB2Binary(RGB rgb){
		int b = ((rgb.getR() * 256) + rgb.getG()) * 256 + rgb.getB();
		return b > 8388608 ? b - 16777216 : b;
	}

	private static float max(float a, float b, float c) {
		float max = a > b ? a : b;
		max = max > c ? max : c;
		return max;
	}

	private static float min(float a, float b, float c) {
		float min = a > b ? b : a;
		min = min > c ? c : min;
		return min;
	}

}
