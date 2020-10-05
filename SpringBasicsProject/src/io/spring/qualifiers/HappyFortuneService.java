package io.spring.qualifiers;

import org.springframework.stereotype.Component;

@Component("happyFortuneServiceQualifier")
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your Lucky Day!!!";
	}

}
