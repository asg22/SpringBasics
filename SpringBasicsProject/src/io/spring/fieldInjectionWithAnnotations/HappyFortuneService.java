package io.spring.fieldInjectionWithAnnotations;

import org.springframework.stereotype.Component;

@Component("happyFortuneServiceFieldInjection")
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your Lucky Day!!!";
	}

}
