
package com.rest.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.client.ReactivePostClient;

/*
 * @Author Debu
 */

@SpringBootApplication
public class ReactivePostApplication {

	private static final Logger log = LoggerFactory.getLogger(ReactivePostApplication.class);

	public static void main(String args[]) {
		SpringApplication.run(ReactivePostApplication.class);
		ReactivePostClient postClient = new ReactivePostClient();
		postClient.doStuff();
	}

}