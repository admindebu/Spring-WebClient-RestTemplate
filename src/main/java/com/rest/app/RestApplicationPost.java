/*package com.rest.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.rest.model.Customer;
import com.rest.model.Customer.CustomerGender;


 * @Author Debu
 

@SpringBootApplication
public class RestApplicationPost {

	private static final Logger log = LoggerFactory.getLogger(RestApplicationPost.class);

	ExecutorService executorService = Executors.newCachedThreadPool();

	long i = 5;

	public static void main(String args[]) {
		SpringApplication.run(RestApplicationPost.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			// get an Customer Data
			
			 * Customer customer =
			 * restTemplate.getForObject("http://localhost:9500/customer/1",
			 * Customer.class); log.info(customer.toString());
			 

			// Post an Customer Data

			executorService.execute(new Runnable() {
				public void run() {
					while (i <= 10000) {
						Customer cust = new Customer(i++, "B", CustomerGender.MALE);
						Customer customer = restTemplate.postForObject("http://localhost:9500/customer", cust,
								Customer.class);
						log.info(customer.toString());
					}
				}
			});

			executorService.shutdown();

		};
	}
}*/