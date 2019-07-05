package de.juli.newjob.controller.aplaystate;

import de.juli.newjob.controller.controller.AplayController;

public abstract class State {
	private String msg;
	protected AplayController controller = new AplayController();
	
	public abstract State start();
	public abstract State create();
	public abstract State documents();
	public abstract State send();
	public abstract State inProgress();
	public abstract State reply();
	public abstract State interview();
	public abstract State hire();
	public abstract State refuse();
	public abstract State retract();	
	public abstract State delete();
	public abstract State close();
	public abstract State reopen();

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
