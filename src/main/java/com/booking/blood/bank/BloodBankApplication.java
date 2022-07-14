package com.booking.blood.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.booking.blood.bank.model.BloodPriceMap;

@SpringBootApplication
public class BloodBankApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(BloodBankApplication.class, args);
	}
	
	@Bean
	public BloodPriceMap initializeBloodPriceMap() {
		return new BloodPriceMap(100, 120, 110, 97, 200, 245, 266, 214);
	}
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }
}
