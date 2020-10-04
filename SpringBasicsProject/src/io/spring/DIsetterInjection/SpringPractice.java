package io.spring.DIsetterInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringPractice {

	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//We have used reactjsFramework class here coz it has additional methods
		ReactJSFramework reactJSTopic = context.getBean("ReactJSTopicsetterInjection",ReactJSFramework.class);
		
		System.out.println(reactJSTopic.getProgrammingTopic());
		System.out.println(reactJSTopic.getDesc());
		System.out.println(reactJSTopic.getFortune());
		
		
		context.close();
	}
}
