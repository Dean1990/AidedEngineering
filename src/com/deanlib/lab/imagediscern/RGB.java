package com.deanlib.lab.imagediscern;

public class RGB {

	// 0~255
	private int r;
	private int g;
	private int b;

	/**
	 * 
	 * @param r
	 *            0~255
	 * @param g
	 *            0~255
	 * @param b
	 *            0~255
	 */
	public RGB(int r, int g, int b) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}

	@Override
	public String toString() {
		return "RGB [r=" + r + ", g=" + g + ", b=" + b + "]";
	}

}
