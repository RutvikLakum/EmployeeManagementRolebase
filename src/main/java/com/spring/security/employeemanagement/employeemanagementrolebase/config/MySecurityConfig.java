package com.spring.security.employeemanagement.employeemanagementrolebase.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class MySecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());

		return provider;

	}

@Bean
SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	
	httpSecurity.csrf(csrf -> csrf.disable())
	.authorizeHttpRequests(requests -> requests.requestMatchers("/signin","/error").permitAll()
			.anyRequest().authenticated())
	.formLogin(formLogin -> formLogin.loginPage("/signin").defaultSuccessUrl("/")
			.failureUrl("/signin?error=true").permitAll())
	.exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/error"))
	.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true));
	
	
	
	return httpSecurity.build();
	
	
	
	
}

}
