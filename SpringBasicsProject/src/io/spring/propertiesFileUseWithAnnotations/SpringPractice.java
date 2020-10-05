package io.spring.propertiesFileUseWithAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringPractice {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		ReactJSFramework topics = context.getBean("reactJSTopic",ReactJSFramework.class);
		
		System.out.println(topics.getProgrammingTopic());
		
		System.out.println(topics.getDesc());
		
		context.close();
	}
}
