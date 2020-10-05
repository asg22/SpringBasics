package io.spring.beanScopeWithAnnotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringPractice {

	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//We have used reactjsFramework class here coz it has additional methods
		ReactJSFramework reactJSTopicObj1 = context.getBean("reactJSBeanScopeWithAnnotation",ReactJSFramework.class);
		ReactJSFramework reactJSTopicObj2 = context.getBean("reactJSBeanScopeWithAnnotation",ReactJSFramework.class);
		
		System.out.println("Objects are Equal?:"+ (reactJSTopicObj1==reactJSTopicObj2));
		System.out.println("Memory location of objects:"+reactJSTopicObj1+" "+reactJSTopicObj2);
		
		context.close();
	}
}
