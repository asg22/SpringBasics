package io.spring.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("javaProgrammingQualifier")
public class JavaProgramming implements ProgrammingTopics {

	@Autowired
	@Qualifier("randomFortuneService")
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
