/*package com.rest.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.rest.model.Customer;


 * @Author Debu
 

@SpringBootApplication
public class ReactiveGetApplication {

	private static final Logger log = LoggerFactory.getLogger(ReactiveGetApplication.class);

	int index = 1;
	long initial = 0;
	long finish = 0;

	public static void main(String args[]) {
		SpringApplication.run(ReactiveGetApplication.class);
	}

	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(WebClient webClient) throws Exception {
		return args -> {

			initial = System.currentTimeMillis();

			System.out.println("Start Execution :: " + initial);

			if (log.isInfoEnabled()) {
				log.info(" get all the customers");
			}

			webClient.get().uri("http://localhost:9500/customers").exchange()
					.flatMapMany(response -> response.bodyToFlux(Customer.class))
					.subscribe(customer -> System.out.println("ALL :: Customer [" + ++index + "] :: " + customer));

			finish = System.currentTimeMillis();

			System.out.println("End Execution :: " + finish);

			log.info("Total Time Taken to rerieve" + (finish - initial));

		};
	}
}*/