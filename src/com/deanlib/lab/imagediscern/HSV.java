package com.deanlib.lab.imagediscern;

public class HSV {
	
	private float h;
	private float s;
	private float v;
	
	/**
	 * 
	 * @param h	0~360
	 * @param s	0~1
	 * @param v	0~1
	 */
	public HSV(float h, float s, float v) {
		super();
		this.h = h;
		this.s = s;
		this.v = v;
	}

	

	public float getH() {
		return h;
	}



	public float getS() {
		return s;
	}



	public float getV() {
		return v;
	}



	@Override
	public String toString() {
		return "HSV [h=" + h + ", s=" + s + ", v=" + v + "]";
	}
	
	

}
