package io.spring.DIconstructorInjection;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your Lucky Day!!!";
	}

}
