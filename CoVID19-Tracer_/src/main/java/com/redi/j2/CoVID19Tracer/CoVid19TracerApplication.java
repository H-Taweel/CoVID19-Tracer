package com.redi.j2.CoVID19Tracer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoVid19TracerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoVid19TracerApplication.class, args);
	}

}
