package com.saicharan.spring.learnspringframework;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.saicharan.spring.learnspringframework.game.GameRunner;
import com.saicharan.spring.learnspringframework.game.MarioGame;
import com.saicharan.spring.learnspringframework.game.PacmanGame;
import com.saicharan.spring.learnspringframework.game.*;
@SpringBootApplication
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context
		= SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		//MarioGame game = new MarioGame();
		//SuperContraGame game =new SuperContraGame();
	    //GamingConsole game =new PacmanGame();
		//GameRunner runner = new GameRunner(game);
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
		
	}

}
