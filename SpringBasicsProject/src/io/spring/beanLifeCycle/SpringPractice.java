package io.spring.beanLifeCycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringPractice {

	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//We have used reactjsFramework class here coz it has additional methods
		ReactJSFramework reactJSTopicObj1 = context.getBean("ReactJSBeanLifeCycle",ReactJSFramework.class);
		
		System.out.println(reactJSTopicObj1.getProgrammingTopic());
		
		context.close();
	}
}
