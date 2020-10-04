package io.spring.DIconstructorInjection;

public class JavaProgramming implements ProgrammingTopics {

	private FortuneService fortuneService;
	
	public JavaProgramming(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	
	@Override
	public String getProgrammingTopic() {
		return "Happy Learning java..";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	

}
