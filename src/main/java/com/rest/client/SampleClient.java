package com.rest.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.rest.model.Customer;
import com.rest.model.Customer.CustomerGender;

import reactor.core.publisher.Mono;

/*
 * @author Debu
 */
public class SampleClient {

	  private WebClient client = WebClient.create("http://localhost:9500");

	  public void doClientJob() {

	    // POST
	    final Customer record = new Customer((long) 1,"B", CustomerGender.MALE);
	    final Mono<ClientResponse> postResponse =
	        client
	            .post()
	            .uri("/customer")
	            .body(Mono.just(record), Customer.class)
	            .accept(MediaType.APPLICATION_JSON)
	            .exchange();
	    postResponse
	        .map(ClientResponse::statusCode)
	        .subscribe(status -> System.out.println("POST: " + status.getReasonPhrase()));

	    // GET
	    client
	        .get()
	        .uri("/customer/{customerId}", "1")
	        .accept(MediaType.APPLICATION_JSON)
	        .exchange()
	        .flatMap(response -> response.bodyToMono(Customer.class))
	        .subscribe(person -> System.out.println("GET: " + person));

	    // ALL
	    client
	        .get()
	        .uri("/customers")
	        .accept(MediaType.APPLICATION_JSON)
	        .exchange()
	        .flatMapMany(response -> response.bodyToFlux(Customer.class))
	        .subscribe(person -> System.out.println("ALL: " + person));

	    // PUT
	    final Customer updated = new Customer((long) 1,"C", CustomerGender.MALE);
	    client
	        .put()
	        .uri("/customer/{customerId}", "1")
	        .body(Mono.just(updated), Customer.class)
	        .accept(MediaType.APPLICATION_JSON)
	        .exchange()
	        .map(ClientResponse::statusCode)
	        .subscribe(response -> System.out.println("PUT: " + response.getReasonPhrase()));

	    // DELETE
	    client
	        .delete()
	        .uri("/customer/{customerId}", "1")
	        .exchange()
	        .map(ClientResponse::statusCode)
	        .subscribe(status -> System.out.println("DELETE: " + status));
	  }
	}