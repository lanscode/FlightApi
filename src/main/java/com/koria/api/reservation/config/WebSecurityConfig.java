package com.koria.api.reservation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
		try {
			httpSecurity.authorizeRequests()
			.antMatchers("/register*","/login","/auth","/findFlight","/flights","/reservation").permitAll()
			.antMatchers("/addFlight").hasAuthority("ADMIN").anyRequest().authenticated().and().csrf().disable();
		} catch (Exception e) {
			  log.error("Exception in {}.{}() with cause = {}");
			e.printStackTrace();
			throw e;
		}
		return httpSecurity.build();
	}
}
