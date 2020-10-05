package io.spring.setterInjectionWithAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("javaProgrammingSetterInjection")
public class JavaProgramming implements ProgrammingTopics {

	private FortuneService fortuneService;
	
	public JavaProgramming() {
		// TODO Auto-generated constructor stub
	}
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}

	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
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
