package com.project.twitterbot;

import java.io.InputStream;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class TwitterAutoBot {

	public static void main(String[] args) {
		tweetLines();
	}

	private static void tweetLines() {
		String line;
		WriteFileExample wfe = new WriteFileExample();
		wfe.ReadDataMakeArray();
		ArrayList<String> list = wfe.kamus;
		Random random = new Random();

		// Deal with the line
		for (int i = 0; i<list.size();i++) {
			String gelo = list.get(random.nextInt(list.size()));
			sendTweet(gelo);
			System.out.println("Tweeting: " + gelo + "...");

			try {
				System.out.println("Sleeping for 30 minutes...");
				Thread.sleep(2400000); // every 40 minutes
				// Thread.sleep(10000); // every 10 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void sendTweet(String line) {
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
