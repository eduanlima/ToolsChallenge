package com.eduanlima.tools_challenge_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eduanlima.tools_challenge_api.utils.SimuladorCartaoCredito;

@SpringBootApplication
public class ToolsChallengeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolsChallengeApiApplication.class, args);
		new SimuladorCartaoCredito();
	}

}
