package br.com.wellington.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "br.com.wellington" })
public class BaseProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseProdutoApplication.class, args);
	}

}
