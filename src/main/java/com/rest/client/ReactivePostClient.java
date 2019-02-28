package com.rest.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.rest.app.ReactivePostApplication;
import com.rest.model.Customer;
import com.rest.model.Customer.CustomerGender;

import reactor.core.publisher.Mono;

public class ReactivePostClient {

	private WebClient client = WebClient.create("http://localhost:9500");

	private static final Logger log = LoggerFactory.getLogger(ReactivePostApplication.class);

	long index = 1;

	public void doStuff() {

		if (log.isInfoEnabled()) {
			log.info(" Post all the customers :: ");
		}

		// Post an Customer Data

		while (index <= 10000) {

			Customer cust = new Customer(index++, "B", CustomerGender.MALE);

			Mono<ClientResponse> postResponse =
					client.post().uri("/customer")
					.body(Mono.just(cust), Customer.class)
					.accept(MediaType.APPLICATION_JSON).exchange();
			
			postResponse.map(ClientResponse::statusCode)
					.subscribe(status -> System.out.println("POST: " + status.getReasonPhrase() +  " :: Customer [" + index + "] :: " + cust.toString()));

		}

	}



}
