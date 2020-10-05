package io.spring.beansWithAnnotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("reactJsCmpScanBeanForJavabasedConfig")
public class ReactJSFramework implements ProgrammingTopics {
	
	private FortuneService fortuneService;
	
	
	public ReactJSFramework(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}

	@Override
	public String getProgrammingTopic() {
		return "Happy Learning ReactJs....All the Best";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	

}
