package com.nabil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component("wfe")
public class WriteFileExample {
	String line;
	String kalimat;
	ArrayList<String> kamus = new ArrayList<String>();

	public void ReadDataMakeArray() {
		try {
			try (InputStream fis = getClass().getResourceAsStream("/nomina.txt");
					InputStreamReader isr = new InputStreamReader(fis, Charset.forName("Cp1252"));
					BufferedReader br = new BufferedReader(isr);) {
				while ((line = br.readLine()) != null) {
					kamus.add(line);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
