package io.spring.fieldInjectionWithAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringPractice {

	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProgrammingTopics topics = context.getBean("javaProgrammingFieldInjection",ProgrammingTopics.class);
		
		System.out.println(topics.getProgrammingTopic());
		System.out.println(topics.getFortune());
		
		context.close();
	}
}
