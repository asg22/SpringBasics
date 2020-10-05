package io.spring.propertiesFileUseWithAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("io.spring.javaBasedConfig")
@PropertySource("classpath:values.properties")
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
