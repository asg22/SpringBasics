package io.spring.propertiesFileUseWithAnnotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("reactJsCmpScanBeanForJavabasedConfig")
public class ReactJSFramework implements ProgrammingTopics {
	
	private FortuneService fortuneService;
	
	@Value("${reactJs.desc}")
	private String desc;
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

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
