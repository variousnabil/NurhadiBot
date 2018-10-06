package com.nabil;

import java.io.InputStream;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TwitterAutoBot {

//	public static void main(String[] args) {
//		tweetLines();
//	}
	@Autowired
	@Qualifier("wfe")
	WriteFileExample wfe;

	public void tweetLines() {
		
		wfe.ReadDataMakeArray();
		ArrayList<String> list = wfe.kamus;
		Random random = new Random();

		// Deal with the line
		while(true) {
			String line = list.get(random.nextInt(list.size()));
			sendTweet(line);
			System.out.println("Tweeting: " + line + "...");

			try {
				System.out.println("Sleeping for 20 minutes...");
// 				Thread.sleep(1200000); // every 20 minutes
				Thread.sleep(30000); // every 10 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void sendTweet(String line) {
		Twitter twitter = TwitterFactory.getSingleton();
		Status status;
		try {
			status = twitter.updateStatus(line);
			System.out.println(status);
		} catch (TwitterException e) {
			;
			e.printStackTrace();
		}
	}

}
