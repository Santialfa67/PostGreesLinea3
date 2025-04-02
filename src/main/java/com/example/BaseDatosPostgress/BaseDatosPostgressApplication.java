package com.example.BaseDatosPostgress;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseDatosPostgressApplication {

	public static void main(String[] args) {
		loadEnv();
		SpringApplication.run(BaseDatosPostgressApplication.class, args);
	}
	private static void loadEnv() {
		Dotenv dotenv = Dotenv.load();

		String url = dotenv.get("DATASOURCE_URL");
		String username = dotenv.get("DATASOURCE_USERNAME");
		String password = dotenv.get("DATASOURCE_PASSWORD");

		System.out.println("DATASOURCE_URL: " + url);
		System.out.println("DATASOURCE_USERNAME: " + username);
		System.out.println("DATASOURCE_PASSWORD: " + password);

		System.setProperty("DATASOURCE_URL", url);
		System.setProperty("DATASOURCE_USERNAME", username);
		System.setProperty("DATASOURCE_PASSWORD", password);
	}
}
