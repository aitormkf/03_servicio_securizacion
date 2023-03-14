package com.cursos.inicio;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration

public class SecurityConfig{ 
	//definición roles y usuarios
	@Bean 
	public InMemoryUserDetailsManager usersDetailsMemory() throws Exception {
		List users=List.of( 
				User.withUsername("user1") 
				.password("{noop}user1") 
				.roles("Invitado") .build(),
				User.withUsername("user2") 
				.password("{noop}user2") 
				.roles("Operador") .build(),
				User.withUsername("admin") 
				.password("{noop}admin") 
				.roles("Admin") .build(),
				User.withUsername("user4") 
				.password("{noop}user4") 
				.roles("Operador", "Admin") 
				.build() );
		return new InMemoryUserDetailsManager(users); } 
	//acceso a recursos
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable() 
		.authorizeHttpRequests() 
		.requestMatchers(HttpMethod.POST,"/curso/alta").hasRole("Admin")
		.requestMatchers(HttpMethod.DELETE,"/curso/eliminar/**").hasRole("Admin")
		.requestMatchers(HttpMethod.DELETE,"/curso/eliminar/**").hasRole("Operador")
		.requestMatchers(HttpMethod.PUT,"/curso/actualizar/**").hasRole("Admin")
		.requestMatchers(HttpMethod.PUT,"/curso/actualizar/**").hasRole("Operador")
		.requestMatchers("/curso/lista").authenticated() 
		.requestMatchers("/curso/buscar/**") .authenticated()
		.requestMatchers("/curso/rango/**") .authenticated()
		.and() 
		.httpBasic(); 
		return http.build(); } }  
