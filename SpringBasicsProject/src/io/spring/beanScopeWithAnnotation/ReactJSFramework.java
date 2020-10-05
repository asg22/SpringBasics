package io.spring.beanScopeWithAnnotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("reactJSBeanScopeWithAnnotation")
@Scope("prototype")
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

}
