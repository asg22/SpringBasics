package io.spring.beansWithAnnotations;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your day..";
	}

}
