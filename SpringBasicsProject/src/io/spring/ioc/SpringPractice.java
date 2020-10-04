package io.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringPractice {

	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProgrammingTopics topics = context.getBean("springTopic",ProgrammingTopics.class);
		
		System.out.println(topics.getProgrammingTopic());
		
		context.close();
	}
}
