package com.feelfreetocode.resttemplatedemo;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class RestTemplateDemoApplicationTests {
	
	@Bean
	RestTemplate getRestTemplate() {
		RestTemplate  restTemplate = new RestTemplate();
		
		MappingJackson2CborHttpMessageConverter cborHttpMessageConverter = new MappingJackson2CborHttpMessageConverter();
		cborHttpMessageConverter.setObjectMapper(new ObjectMapper());
		
		restTemplate.getMessageConverters().add(cborHttpMessageConverter);
		return restTemplate;
	}

	@Test
	void contextLoads() {
	}	

}
