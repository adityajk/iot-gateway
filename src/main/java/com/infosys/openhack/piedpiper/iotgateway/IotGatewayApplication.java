package com.infosys.openhack.piedpiper.iotgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@IntegrationComponentScan
@EnableCaching
@EnableScheduling
public class IotGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotGatewayApplication.class, args);
	}
}
