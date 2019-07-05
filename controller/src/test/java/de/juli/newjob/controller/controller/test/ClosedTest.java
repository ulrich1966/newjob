package de.juli.newjob.controller.controller.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.juli.newjob.controller.aplaystate.Closed;
import de.juli.newjob.controller.aplaystate.ReOpen;
import de.juli.newjob.controller.controller.Application;
import de.juli.newjob.recource.tools.PrettyLog;

public class ClosedTest {
	private static final Logger LOG = LoggerFactory.getLogger(ClosedTest.class);
	private static final PrettyLog LOG_P = new PrettyLog(LOG);

	// {@link ReOpen}, {@ Deleted}
	
	private static Application app;

	@Test
	public void testAppReopen() {
		app = new Application();
		app.setCurrentState(new Closed());
		testReopen();
	}

	@Test
	public void testAppDelete() {
		app = new Application();
		app.setCurrentState(new Closed());
		testDelete();
	}
	
	private void testDelete() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Closed);
		app.reopen();
		Assert.assertTrue("no instance of ReOpen", app.getCurrentState() instanceof ReOpen);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	private void testReopen() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Closed);
		app.reopen();
		Assert.assertTrue("no instance of ReOpen", app.getCurrentState() instanceof ReOpen);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}
}