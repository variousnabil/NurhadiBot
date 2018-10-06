package com.nabil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NurhadibotApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(NurhadibotApplication.class, args);
		TwitterAutoBot autobot = ac.getBean(TwitterAutoBot.class);
		autobot.tweetLines();
	}
}
