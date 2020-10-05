package io.spring.setterInjectionWithAnnotations;

import org.springframework.stereotype.Component;

@Component("happyFortuneServiceSetterInjection")
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your Lucky Day!!!";
	}

}
