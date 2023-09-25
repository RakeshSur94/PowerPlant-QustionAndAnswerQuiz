package com.pp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperCofig {
	@Bean
	public ModelMapper createMapper() {
		return new ModelMapper();
	}

}
