package model;

import game.maker.GameMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TimerDisplayThread implements ActionListener {

	private GameMaker gameMaker;
	
	public TimerDisplayThread(GameMaker gameMaker){
		this.gameMaker=gameMaker;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	gameMaker.getGamePanel().draw(gameMaker.getGamePanel().getSpriteList());		
	}
}
