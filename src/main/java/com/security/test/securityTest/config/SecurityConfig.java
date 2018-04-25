package com.security.test.securityTest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
		
		authBuilder.inMemoryAuthentication()
			.withUser("rakczis")
			.password("{noop}12345") //"{noop}12345"
			.authorities("ROLE_USER");
	}

	@Override
	public void configure(final HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.cors().and()
			.csrf().and()
			.authorizeRequests()
			.antMatchers("/info").permitAll()
			.antMatchers("/health").permitAll()
			.anyRequest()
			.authenticated().and()
			.httpBasic();
	}
	
//	@SuppressWarnings("deprecation")
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
}
