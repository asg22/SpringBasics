package io.spring.fieldInjectionWithAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("javaProgrammingFieldInjection")
public class JavaProgramming implements ProgrammingTopics {

	@Autowired
	private FortuneService fortuneService;
	
	public JavaProgramming() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getProgrammingTopic() {
		return "Happy Learning java..All the Best for your future";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	

}
