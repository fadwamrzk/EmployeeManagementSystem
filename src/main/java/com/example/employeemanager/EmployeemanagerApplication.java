package com.example.employeemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@SpringBootApplication
public class EmployeemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}

	//By using the @Bean annotation on a method, you are instructing the Spring container to manage the object returned
	// by that method as a bean. The method name (corsFilter() in this case) becomes the name of the bean within the container
	@Bean
	//The CORS (Cross-Origin Resource Sharing) filter allows you to define rules for allowing or restricting cross-origin requests to your application
	public CorsFilter corsFilter() {

		CorsConfiguration corsCongiguration = new CorsConfiguration();
		corsCongiguration.setAllowCredentials(true);

		//specifies that requests from the specified origin (http://localhost:4200) are allowed
		corsCongiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));

		//sets the allowed headers for the requests
		corsCongiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control.Allow.Origin","content-Type","Accept","Authorization",
				"Origin,Accept","X-Request-With",
				"Access-Control-Request-Method","Acces-Control-Request-Headers"));

		//sets the headers that are exposed to the client in the response
		corsCongiguration.setExposedHeaders(Arrays.asList("Origin", "content-Type","Accept","Authorization",
				"Access-Control-Allow-Origin","Access-Control-Allow-Origin","Access-Control-Allow-Credentials"));

		//specifies the allowed HTTP methods for the requests
		corsCongiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));

		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource=new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsCongiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
}


