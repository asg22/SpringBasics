package io.spring.beanLifeCycle;

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
	
	
	public void startUpMethod()
	{
		System.out.println("Bean Initialization done");
	}
	
	public void cleanUpMethod()
	{
		System.out.println("Clean up done");
	}

}
