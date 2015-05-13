package com.deanlib.lab.repetition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Repetition {

	public static final int LEN = 10;
	public static final int TIME = 10;

	public static void extract(File file, FileOutputStream out)
			throws Exception {
		if (file.exists()) {

			if (file.isDirectory()) {
				File[] listFiles = file.listFiles();
				for (int i = 0; i < listFiles.length; i++) {
					extract(listFiles[i], out);
				}
			} else {
				try {
					byte[] feature = new byte[LEN * TIME];
					long seek = file.length() / (TIME + 1);
					FileInputStream in = new FileInputStream(file);
					if (seek > LEN) {
						byte[] b = new byte[LEN];
						for (int i = 0; i < TIME; i++) {
							if (in.skip(seek) != -1 && in.read(b) != -1)
								for (int j = 0; j < LEN; j++) {
									feature[i * LEN + j] = b[j];
								}
						}
					} else {
						in.read(feature);
					}
					out.write(feature);
					out.write("   ".getBytes());
					out.write(file.getAbsolutePath().getBytes());
					out.write("\n\r".getBytes());
					System.out.println(file);
					in.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			out.flush();
		}
	}

}
