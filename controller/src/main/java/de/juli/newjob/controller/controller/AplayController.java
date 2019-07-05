package de.juli.newjob.controller.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.juli.newjob.controller.aplaystate.State;
import de.juli.newjob.recource.tools.PrettyLog;


public class AplayController {
	private static final Logger LOG = LoggerFactory.getLogger(AplayController.class);
	private static final PrettyLog LOG_P = new PrettyLog(LOG);
	
	public boolean run(String msg) {
		LOG_P.info(msg);
		return true;
	}

	public boolean run(State state, String msg) {
		LOG_P.info(state.getClass().getSimpleName(), msg);
		return true;
	}

}
