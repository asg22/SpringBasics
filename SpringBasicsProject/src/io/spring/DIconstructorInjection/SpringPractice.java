package io.spring.DIconstructorInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringPractice {

	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProgrammingTopics topics = context.getBean("springTopicConstructorInjection",ProgrammingTopics.class);
		
		System.out.println(topics.getProgrammingTopic());
		System.out.println(topics.getFortune());
		
		context.close();
	}
}
