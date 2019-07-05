package de.juli.newjob.controller.controller.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.juli.newjob.controller.aplaystate.Closed;
import de.juli.newjob.controller.aplaystate.ReOpen;
import de.juli.newjob.controller.aplaystate.Refused;
import de.juli.newjob.controller.controller.Application;
import de.juli.newjob.recource.tools.PrettyLog;

public class RefuseTest {
	private static final Logger LOG = LoggerFactory.getLogger(RefuseTest.class);
	private static final PrettyLog LOG_P = new PrettyLog(LOG);

	private static Application app;
	
	// {@link Closed}, {@link ReOpen}

	@Test
	public void testAppClose() {
		app = new Application();
		app.setCurrentState(new Refused());
		testClose();
	}

	@Test
	public void testAppDocuments() {
		app = new Application();
		app.setCurrentState(new Refused());
		testReopen();
	}

	private void testReopen() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Refused);
		app.reopen();
		Assert.assertTrue("no instance of Documents", app.getCurrentState() instanceof ReOpen);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	private void testClose() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Refused);
		app.close();
		Assert.assertTrue("no instance of Documents", app.getCurrentState() instanceof Closed);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());		
	}
}