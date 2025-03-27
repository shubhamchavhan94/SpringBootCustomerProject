package com.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomerSecurity {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails rushikesh = User.builder()
				                .username("rushikesh")
				                .password("{noop}test@123")
				                .roles("EMPLOYEE")
				                .build();
		
		UserDetails shubham = User.builder()
                .username("shubham")
                .password("{noop}test@123")
                .roles("EMPLOYEE","MANAGER")
                .build();
		
		UserDetails renuka = User.builder()
                .username("renuka")
                .password("{noop}test@123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();
		
		return new InMemoryUserDetailsManager(rushikesh,shubham,renuka);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(configurer ->
						configurer
						  .requestMatchers(HttpMethod.GET, "/api/customers/getall").hasRole("EMPLOYEE")
						  .requestMatchers(HttpMethod.GET,"/api/customers/**").hasRole("EMPLOYEE")
						  .requestMatchers(HttpMethod.GET,"/api/images/**").hasRole("EMPLOYEE")
						  .requestMatchers(HttpMethod.GET,"/api/sendmailapp").hasRole("EMPLOYEE")
						  .requestMatchers(HttpMethod.POST, "/api/customers/save").hasRole("MANAGER")
						  .requestMatchers(HttpMethod.POST, "/api/images").hasRole("MANAGER")
						  .requestMatchers(HttpMethod.POST,"/api/send-email-attachment").hasRole("MANAGER")
						  .requestMatchers(HttpMethod.PUT,"/api/customers/update").hasRole("MANAGER")
						  .requestMatchers(HttpMethod.DELETE, "/api/customers/delete/**").hasRole("ADMIN")
				);
		
		//use http basic authentication
		http.httpBasic(Customizer.withDefaults());
		
		//disable csrf
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}

}
