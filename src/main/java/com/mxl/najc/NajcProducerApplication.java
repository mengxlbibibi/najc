package com.mxl.najc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mxl.najc.dao")
public class NajcProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NajcProducerApplication.class, args);
	}

}
