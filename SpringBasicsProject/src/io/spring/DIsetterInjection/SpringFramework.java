package io.spring.DIsetterInjection;

public class SpringFramework implements ProgrammingTopics{

	private FortuneService fortuneService;
	
	
	public SpringFramework(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getProgrammingTopic() {
		
		return "Happy Learning Spring";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	

}
