package com.cgling.tms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.cgling.tms.**.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
