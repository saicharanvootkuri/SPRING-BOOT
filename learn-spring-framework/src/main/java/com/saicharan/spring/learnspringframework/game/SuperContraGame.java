package com.saicharan.spring.learnspringframework.game;
import org.springframework.stereotype.Component;

@Component

public class SuperContraGame implements GamingConsole {
	
	public void up() {
		System.out.println("supercontrajump");
	}
	public void down() {
		System.out.println("supercontradown");
	}
	public void left() {
		System.out.println("supercontraleft");
	}
	public void right() {
		System.out.println("supercontraright");
	}

}
