package com.test02;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageTest {
	
	public static void main(String[] args) throws IOException {
		String fileName = "money.jpg";
		
		/*
		FileInputStream fi = new FileInputStream(fileName);
		BufferedInputStream bi = new BufferedInputStream(fi);
		*/
		
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(fileName));
		
		FileOutputStream fo = new FileOutputStream(new File("dollar.jpg"));
		
		int a = 0;
		while((a = bi.read()) != -1){
			fo.write(a);
		}
		
		fo.close();
		bi.close();
		
	}

}
