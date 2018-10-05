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
	File file = new File("d:/newfile.txt");
	
	public static void main(String[] args) {
		WriteFileExample wfe = new WriteFileExample();
		wfe.ReadDataMakeArray();
		wfe.WriteData();
		
	}
	
	public void WriteData() {
		try (FileOutputStream fop = new FileOutputStream(file);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fop));) {

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			
			for (String string : kamus) {
				bw.write(string);
				bw.newLine();
			}
			
			if (kalimat.equals(null)) {
				fop.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ReadDataMakeArray() {
		try {
			try (InputStream fis = new FileInputStream("D:\\eclipse-workspace\\twitterbot\\src\\main\\resources\\nomina.txt");
					InputStreamReader isr = new InputStreamReader(fis, Charset.forName("Cp1252"));
					BufferedReader br = new BufferedReader(isr);) {
				while ((line = br.readLine()) != null) {
					kalimat = line + " bangsat kau";
					System.out.println(kalimat);
					kamus.add(kalimat);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
