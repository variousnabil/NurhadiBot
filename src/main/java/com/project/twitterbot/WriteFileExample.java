package com.project.twitterbot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WriteFileExample {
	String line;
	String kalimat;
	ArrayList<String> kamus = new ArrayList<String>();
	
	public void ReadDataMakeArray() {
		try {
			try {
				InputStream fis = new FileInputStream("src\\main\\resources\\nomina.txt");
					InputStreamReader isr = new InputStreamReader(fis, Charset.forName("Cp1252"));
					BufferedReader br = new BufferedReader(isr);
				while ((line = br.readLine()) != null) {
					kalimat = line + " bangsat kau";
					System.out.println(kalimat);
					kamus.add(kalimat);
				}

			}catch (IOException e) {
			e.printStackTrace();
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
