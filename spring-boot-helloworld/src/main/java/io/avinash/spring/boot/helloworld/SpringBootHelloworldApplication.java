package io.avinash.spring.boot.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHelloworldApplication  {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloworldApplication.class, args);
	}


}
