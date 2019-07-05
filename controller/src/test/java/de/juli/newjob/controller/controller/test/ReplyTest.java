package de.juli.newjob.controller.controller.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.juli.newjob.controller.aplaystate.Hired;
import de.juli.newjob.controller.aplaystate.Invited;
import de.juli.newjob.controller.aplaystate.Refused;
import de.juli.newjob.controller.aplaystate.Replied;
import de.juli.newjob.controller.aplaystate.Retracted;
import de.juli.newjob.controller.controller.Application;
import de.juli.newjob.recource.tools.PrettyLog;

public class ReplyTest {
	private static final Logger LOG = LoggerFactory.getLogger(ReplyTest.class);
	private static final PrettyLog LOG_P = new PrettyLog(LOG);
	
	private static Application app;
	
	@Test
	public void testAppRefuse() {
		app = new Application();
		app.setCurrentState(new Replied());
		testRefuse();
	}

	@Test
	public void testAppInterview() {
		app = new Application();
		app.setCurrentState(new Replied());
		testInterview();
	}

	@Test
	public void testAppRetract() {
		app = new Application();
		app.setCurrentState(new Replied());
		testRetract();		
	}

	@Test
	public void testAppHire() {
		app = new Application();
		app.setCurrentState(new Replied());
		testHire();		
	}
	
	public void testInterview() {
		Assert.assertTrue("no instance of Started", app.getCurrentState() instanceof Replied);
		app.interview();
		Assert.assertTrue("no instance of Started", app.getCurrentState() instanceof Invited);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	public void testRefuse() {
		Assert.assertTrue("no instance of Started", app.getCurrentState() instanceof Replied);
		app.refuse();
		Assert.assertTrue("no instance of Started", app.getCurrentState() instanceof Refused);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	public void testRetract() {
		Assert.assertTrue("no instance of Started", app.getCurrentState() instanceof Replied);
		app.retract();
		Assert.assertTrue("no instance of Started", app.getCurrentState() instanceof Retracted);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	public void testHire() {
		Assert.assertTrue("no instance of Started", app.getCurrentState() instanceof Replied);
		app.hire();
		Assert.assertTrue("no instance of Started", app.getCurrentState() instanceof Hired);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}
}