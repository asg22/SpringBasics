package io.spring.javaBasedConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringPractice {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		ProgrammingTopics topics = context.getBean("reactJsCmpScanBeanForJavabasedConfig",ProgrammingTopics.class);
		
		System.out.println(topics.getProgrammingTopic());
		
		context.close();
	}
}
