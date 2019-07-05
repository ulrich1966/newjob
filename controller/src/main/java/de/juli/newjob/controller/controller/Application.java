package de.juli.newjob.controller.controller;

import de.juli.newjob.controller.aplaystate.Started;
import de.juli.newjob.controller.aplaystate.State;

public class Application {
	private State currentState = new Started();

	public void start() {
		this.currentState = currentState.start();
	}

	public void create() {
		this.currentState = currentState.create();
	}

	public void documents() {
		this.currentState = currentState.documents();
	}

	public void send() {
		this.currentState = currentState.send();
	}

	public void inProgress() {
		this.currentState = currentState.inProgress();
	}

	public void reply() {
		this.currentState = currentState.reply();
	}

	public void interview() {
		this.currentState = currentState.interview();
	}

	public void refuse() {
		this.currentState = currentState.refuse();
	}

	public void retract() { 
		this.currentState = currentState.retract();
	}

	public void hire() { 
		this.currentState = currentState.hire();
	}

	public void reopen() { 
		this.currentState = currentState.reopen();
	}

	public void delete() { 
		this.currentState = currentState.delete();
	}
	
	public void close() {
		this.currentState = currentState.close();
	}	

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
}
