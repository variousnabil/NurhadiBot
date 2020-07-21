package com.nabil;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TwitterAutoBot {
	@Autowired
	@Qualifier("wfe")
	WriteFileExample wfe;

	public void tweetLines() {
		wfe.ReadDataMakeArray();
		ArrayList<String> list = wfe.kamus;
		Random random = new Random();
		// Infinite Loop for twitter worker :( BATCH WORK!
		while (true) {
			String line = list.get(random.nextInt(list.size()));
			sendTweet(line);
			System.out.println("Tweeting: " + line + "...");
			try {
				System.out.println("Sleeping for 1 day...");
				Thread.sleep(86400000); // every 1 day
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
