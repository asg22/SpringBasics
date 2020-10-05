package io.spring.constructorInjectionWithAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JavaProgramming implements ProgrammingTopics {

	private FortuneService fortuneService;
	
	@Autowired
	public JavaProgramming(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	
	@Override
	public String getProgrammingTopic() {
		return "Happy Learning java..All the Best";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	

}
