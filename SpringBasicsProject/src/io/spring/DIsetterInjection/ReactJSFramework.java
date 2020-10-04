package io.spring.DIsetterInjection;

public class ReactJSFramework implements ProgrammingTopics {

	private FortuneService fortuneService;
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

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}


	@Override
	public String getProgrammingTopic() {
		return "Happy Learning ReactJs....";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
