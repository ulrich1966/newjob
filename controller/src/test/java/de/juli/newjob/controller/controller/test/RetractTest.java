package de.juli.newjob.controller.controller.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.juli.newjob.controller.aplaystate.Closed;
import de.juli.newjob.controller.aplaystate.Retracted;
import de.juli.newjob.controller.controller.Application;
import de.juli.newjob.recource.tools.PrettyLog;

public class RetractTest {
	private static final Logger LOG = LoggerFactory.getLogger(RetractTest.class);
	private static final PrettyLog LOG_P = new PrettyLog(LOG);

	private static Application app;
	
	// {@link Closed}

	@Test
	public void testAppRetract() {
		app = new Application();
		app.setCurrentState(new Retracted());
		testClose();
	}

	private void testClose() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Retracted);
		app.close();
		Assert.assertTrue("no instance of Documents", app.getCurrentState() instanceof Closed);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());		
	}
}