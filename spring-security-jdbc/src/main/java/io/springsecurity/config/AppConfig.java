package io.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.zaxxer.hikari.HikariDataSource;

import io.springsecurity.config.filter.CorsFilter;
import io.springsecurity.security.AuthEntryPointJwt;
import io.springsecurity.security.AuthTokenFilter;
import io.springsecurity.service.UserService;

@Configuration("AppConfig")
@ConfigurationProperties(prefix = "demo")
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

	private String swaggerPathPrefix = "/";
	private Integer jdbcFetchRowSize = 1000;

	@Autowired
	UserService userService;
	/*
	 * @Autowired CorsFilter corsFilter;
	 */

	@Primary
	@Bean(name = "DataSourceSpringSec")
	@ConfigurationProperties(prefix = "demo.datasource.mvh")
	public DataSource springSecDataSource() {
		HikariDataSource hds = (HikariDataSource) DataSourceBuilder.create().username("root").password("password")
				.build();
		return hds;
	}

	@Bean(name = "JdbcTemplateSpringSec")
	public JdbcTemplate springSec() {
		System.out.println("creating bean");
		System.out.println("demo.datasource.mvh.jdbcUrl");
		return new JdbcTemplate(springSecDataSource());
	}

	public String getSwaggerPathPrefix() {
		return swaggerPathPrefix;
	}

	public void setSwaggerPathPrefix(String swaggerPathPrefix) {
		this.swaggerPathPrefix = swaggerPathPrefix;
	}

	public Integer getJdbcFetchRowSize() {
		return jdbcFetchRowSize;
	}

	public void setJdbcFetchRowSize(Integer jdbcFetchRowSize) {
		this.jdbcFetchRowSize = jdbcFetchRowSize;
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	
	  @Autowired 
	  private AuthEntryPointJwt unauthorizedHandler;
	  
	  
	  @Bean public AuthTokenFilter authenticationJwtTokenFilter() { return new
	  AuthTokenFilter(); }
	 

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().exceptionHandling(). authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers("/v2/api-docs", "/webjars/**", "/metrics", "/monitor", "/ping", "/health",
						"/configuration/ui", "/configuration/security", "/swagger-ui.html", "/swagger-resources",
						"/swagger-resources/configuration/ui", "/swagger-resources/configuration/security", "/login")
				.permitAll().antMatchers("/**").authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
