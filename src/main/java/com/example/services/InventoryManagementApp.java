package com.example.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
public class InventoryManagementApp {
	private static final Logger log = LoggerFactory.getLogger(InventoryManagementApp.class);

	public static void main(String[] args) {
		//log.info("WarehouseApp Aplication Starting...");
		SpringApplication.run(InventoryManagementApp.class, args);
	}

}
