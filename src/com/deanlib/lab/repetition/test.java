package com.deanlib.lab.repetition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class test {
	
	public static void main(String[] args) {
		
		try {
			FileOutputStream out = new FileOutputStream("C:/feature.txt");
			Repetition.extract(new File("D:/IMAGE"),out);
			out.close();
			
			/*System.out.println("-----------");
			FileInputStream in = new FileInputStream("C:/feature.txt");
			byte[] b = new byte[2048];
			in.read(b);
			String s = new String(b);
			String[] split = s.split("\n\r");
			for (int i = 0; i < split.length; i++) {
				
				System.out.println(i+":"+split[i]);
			}
			System.out.println(split[2].split("   ")[0].equals(split[1].split("   ")[0]));*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
