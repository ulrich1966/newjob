package de.juli.newjob.controller.controller.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.juli.newjob.controller.aplaystate.InProgress;
import de.juli.newjob.controller.aplaystate.Sended;
import de.juli.newjob.controller.controller.Application;
import de.juli.newjob.recource.tools.PrettyLog;

public class SendTest {
	private static final Logger LOG = LoggerFactory.getLogger(SendTest.class);
	private static final PrettyLog LOG_P = new PrettyLog(LOG);

	private static Application app;
	
	// {@link Closed}

	@Test
	public void testAppSend() {
		app = new Application();
		app.setCurrentState(new Sended());
		testInProgress();
	}

	private void testInProgress() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Sended);
		app.inProgress();
		Assert.assertTrue("no instance of Documents", app.getCurrentState() instanceof InProgress);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());		
	}
}