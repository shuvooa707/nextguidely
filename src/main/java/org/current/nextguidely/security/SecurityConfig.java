package org.current.nextguidely.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {



	@Bean
	String passwordEncoder() {
		return "";
	}
}
