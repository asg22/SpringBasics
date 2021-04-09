package io.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.springsecurity.config.filter.CorsFilter;
import io.springsecurity.security.AuthEntryPointJwt;
import io.springsecurity.security.AuthTokenFilter;

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}
	
	/*@Bean
	public CorsFilter corsCheckFilter() {
		return new CorsFilter();
	}*/
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	        .antMatchers(
	                "/v2/api-docs",
	                "/webjars/**",
	                "/metrics",
	                "/monitor",
	                "/ping",
	                "/health",
	                "/configuration/ui",
	                "/configuration/security",
	                "/swagger-ui.html",
	                "/swagger-resources",
	                "/swagger-resources/configuration/ui",
	                "/swagger-resources/configuration/security",
	                "/login").permitAll()
	        .antMatchers("/**").authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		//http.addFilterBefore(corsCheckFilter(), org.springframework.web.filter.CorsFilter.class);
	}
	
	

}
