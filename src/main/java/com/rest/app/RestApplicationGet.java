/*package com.rest.app;

import java.util.List;


 * @Author Debu
 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rest.model.Customer;

@SpringBootApplication
public class RestApplicationGet {

	private static final Logger log = LoggerFactory.getLogger(RestApplicationGet.class);

	int index = 1;
	long initial = 0;
	long finish = 0;

	public static void main(String args[]) {
		SpringApplication.run(RestApplicationGet.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			// get an Customer Data

			ResponseEntity<List<Customer>> response = restTemplate.exchange("http://localhost:9500/customers",
					HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {
					});
			List<Customer> customers = response.getBody();

			for (Customer customer : customers) {

				log.info("ALL :: Customer [" + ++index + "] :: " + customer.toString());

			}

		};
	}
}*/