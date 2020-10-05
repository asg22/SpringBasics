package io.spring.javaBasedConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("reactJsCmpScanBeanForJavabasedConfig")
public class ReactJSFramework implements ProgrammingTopics {
	@Value("This is ReactJS framework")
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
		return "Happy Learning ReactJs....All the Best";
	}

}
