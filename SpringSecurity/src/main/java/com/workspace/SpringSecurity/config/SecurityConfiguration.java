package com.workspace.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//set authentication and authorization details 
		auth.inMemoryAuthentication()
		.withUser("priyo_dev")
		.password("abcd@dev")
		.roles("DEV")
		.and()
		.withUser("priyo_qa")
		.password("abcd@qa")
		.roles("QA")
		.and()
		.withUser("admin")
		.password("123@admin")
		.roles("ADMIN"); 
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/greet/users").hasAnyRole("DEV")
		.antMatchers("/greet/admin").hasRole("ADMIN")
		.and()
		.formLogin();
	}
	
	@Bean //get password encoded.<deprecated>
	public NoOpPasswordEncoder getEncodedPass() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
