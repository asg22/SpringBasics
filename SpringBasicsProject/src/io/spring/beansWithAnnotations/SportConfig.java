package io.spring.beansWithAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("io.spring.javaBasedConfig")
public class SportConfig {

	
	@Bean
	public FortuneService happyFortuneService()
	{
		return new HappyFortuneService();
	}
	
	@Bean
	public ProgrammingTopics reactJSTopic()
	{
		return new ReactJSFramework(happyFortuneService());
	}
	
}
