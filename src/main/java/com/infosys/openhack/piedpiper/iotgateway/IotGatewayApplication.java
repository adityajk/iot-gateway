package com.infosys.openhack.piedpiper.iotgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;

@SpringBootApplication
@IntegrationComponentScan
public class IotGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotGatewayApplication.class, args);
	}
}
