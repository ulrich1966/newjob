package de.juli.newjob.controller.controller.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.juli.newjob.controller.aplaystate.Hired;
import de.juli.newjob.controller.aplaystate.Invited;
import de.juli.newjob.controller.aplaystate.Refused;
import de.juli.newjob.controller.aplaystate.Retracted;
import de.juli.newjob.controller.controller.Application;
import de.juli.newjob.recource.tools.PrettyLog;

public class InvideTest {
	private static final Logger LOG = LoggerFactory.getLogger(InvideTest.class);
	private static final PrettyLog LOG_P = new PrettyLog(LOG);

	private static Application app;
	
	// {@link Refused}, {@link Retracted}, {@link Hired}

	@Test
	public void testAppHire() {
		app = new Application();
		app.setCurrentState(new Invited());
		testHire();
	}

	@Test
	public void testAppRefused() {
		app = new Application();
		app.setCurrentState(new Invited());
		testRefused();
	}
	

	@Test
	public void testAppRetracted() {
		app = new Application();
		app.setCurrentState(new Invited());
		testRetracted();
	}

	private void testRetracted() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Invited);
		app.retract();
		Assert.assertTrue("no instance of Closed", app.getCurrentState() instanceof Retracted);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	private void testRefused() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Invited);
		app.refuse();
		Assert.assertTrue("no instance of Closed", app.getCurrentState() instanceof Refused);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	private void testHire() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Invited);
		app.hire();
		Assert.assertTrue("no instance of Closed", app.getCurrentState() instanceof Hired);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
		
	}
}