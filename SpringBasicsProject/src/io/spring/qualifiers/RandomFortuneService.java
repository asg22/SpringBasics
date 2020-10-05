package io.spring.qualifiers;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService{

	private String[] data={"You are luckier","Please be safe","Today is your best day"};
	
	private Random rand = new Random();
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return data[rand.nextInt(data.length)];
	}

}
