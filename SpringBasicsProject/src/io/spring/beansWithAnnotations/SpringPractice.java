package io.spring.beansWithAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringPractice {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		ProgrammingTopics topics = context.getBean("reactJSTopic",ProgrammingTopics.class);
		
		System.out.println(topics.getProgrammingTopic());
		
		System.out.println(topics.getDailyFortune());
		
		context.close();
	}
}
