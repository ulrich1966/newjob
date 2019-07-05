package de.juli.newjob.controller.controller.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.juli.newjob.controller.aplaystate.Closed;
import de.juli.newjob.controller.aplaystate.Hired;
import de.juli.newjob.controller.controller.Application;
import de.juli.newjob.recource.tools.PrettyLog;

public class HiredTest {
	private static final Logger LOG = LoggerFactory.getLogger(HiredTest.class);
	private static final PrettyLog LOG_P = new PrettyLog(LOG);

	private static Application app;
	
	//{@link Closed}

	@Test
	public void testAppHire() {
		app = new Application();
		app.setCurrentState(new Hired());
		testHire();
	}

	private void testHire() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Hired);
		app.close();
		Assert.assertTrue("no instance of Closed", app.getCurrentState() instanceof Closed);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
		
	}
}