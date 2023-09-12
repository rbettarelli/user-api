package me.dio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default Server URL") })
@SpringBootApplication
public class Application {

	@Value("${spring.profiles.active}")
	private String activeProfile;

	public static void main(String[] args) {
		
		
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void init() {
		if (activeProfile.equals("dev")) {
			System.setProperty("spring.config.name", "application-dev");
		} else if (activeProfile.equals("prd")) {
			System.setProperty("spring.config.name", "application-prd");
		}
	}

}
