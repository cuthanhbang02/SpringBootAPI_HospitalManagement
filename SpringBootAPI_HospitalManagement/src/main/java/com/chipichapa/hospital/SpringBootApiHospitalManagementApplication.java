package com.chipichapa.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = { SpringBootApiHospitalManagementApplication.class})
public class SpringBootApiHospitalManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiHospitalManagementApplication.class, args);
	}

}
