package io.spring.securitydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfigClass extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication().
		withUser(users.username("Akshay").password("test123").roles("EMPLOYEE")).
		withUser(users.username("Akki").password("test123").roles("EMPLOYEE","MANAGER","ADMIN")).
		withUser(users.username("ASG").password("test123").roles("EMPLOYEE","ADMIN"))
		.withUser(users.username("Asg1").password("test123").roles("EMPLOYEE","MANAGER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and()
		.formLogin()
		.loginPage("/loginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll().and()
		.logout()
		.permitAll().and()
		.exceptionHandling()
		.accessDeniedPage("/access-denied");
	}

	
	
	
	

}
