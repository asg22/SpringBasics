package io.spring.beanLifeCycleWithAnnotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component("reactJsBeanLifeCycleWithAnnotation")
public class ReactJSFramework implements ProgrammingTopics {

	private String desc;
	
	
	public ReactJSFramework() {
		// TODO Auto-generated constructor stub
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


	@Override
	public String getProgrammingTopic() {
		return "Happy Learning ReactJs....";
	}
	
	
	@PostConstruct
	public void startUpMethod()
	{
		System.out.println("Bean Initialization done with annotations");
	}
	
	@PreDestroy
	public void cleanUpMethod()
	{
		System.out.println("Clean up done with annotations");
	}

}
