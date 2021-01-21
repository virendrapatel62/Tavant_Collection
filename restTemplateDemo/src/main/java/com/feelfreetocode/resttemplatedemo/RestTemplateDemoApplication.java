package com.feelfreetocode.resttemplatedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;

@SpringBootApplication
public class RestTemplateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateDemoApplication.class, args);
		
		System.out.println("RestTemplateDemoApplication.main()");
		System.err.println(getRestTemplate());
		
 
	}
	
	static RestTemplate getRestTemplate() {
		RestTemplate  restTemplate = new RestTemplate();
		
		MappingJackson2CborHttpMessageConverter convertor = 
				new MappingJackson2CborHttpMessageConverter();
		
		ObjectMapper mapper = new ObjectMapper(new CBORFactory());
		convertor.setObjectMapper(mapper);
		 
		restTemplate.getMessageConverters().add(convertor);
		return restTemplate;
	}

}
