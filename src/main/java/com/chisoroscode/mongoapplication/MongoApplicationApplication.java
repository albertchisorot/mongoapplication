package com.chisoroscode.mongoapplication;

import com.chisoroscode.mongoapplication.service.AccountService;
import com.chisoroscode.mongoapplication.service.requests.AccountRequest;
import com.chisoroscode.mongoapplication.service.requests.TransferRequest;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.math.BigDecimal;

@SpringBootApplication
@EnableSwagger2
@AllArgsConstructor
public class MongoApplicationApplication {
	private final AccountService accountService;
    public static void main(String[] args) {
		SpringApplication.run(MongoApplicationApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){

		TransferRequest transferRequest=new TransferRequest();
		transferRequest.setSource("Albert");
		transferRequest.setDestination("Rudo");
		transferRequest.setAmount(BigDecimal.valueOf(1000000));
		accountService.transferMoney(transferRequest);
		return null;
	}
}
