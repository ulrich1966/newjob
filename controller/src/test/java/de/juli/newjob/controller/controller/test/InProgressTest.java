package de.juli.newjob.controller.controller.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.juli.newjob.controller.aplaystate.Closed;
import de.juli.newjob.controller.aplaystate.InProgress;
import de.juli.newjob.controller.aplaystate.Invited;
import de.juli.newjob.controller.aplaystate.Refused;
import de.juli.newjob.controller.aplaystate.Replied;
import de.juli.newjob.controller.aplaystate.Retracted;
import de.juli.newjob.controller.controller.Application;
import de.juli.newjob.recource.tools.PrettyLog;

public class InProgressTest {
	private static final Logger LOG = LoggerFactory.getLogger(InProgressTest.class);
	private static final PrettyLog LOG_P = new PrettyLog(LOG);
	
	private static Application app;
	
	@Test
	public void testAppRefuse() {
		app = new Application();
		app.setCurrentState(new InProgress());
		testRefuse();
	}

	@Test
	public void testAppReply() {
		app = new Application();
		app.setCurrentState(new InProgress());
		testReply();
	}

	@Test
	public void testAppInterview() {
		app = new Application();
		app.setCurrentState(new InProgress());
		testInterview();
	}

	@Test
	public void testAppRetract() {
		app = new Application();
		app.setCurrentState(new InProgress());
		testRetract();		
	}

	@Test
	public void testAppClose() {
		app = new Application();
		app.setCurrentState(new InProgress());
		testClose();		
	}

	public void testReply() {
		Assert.assertTrue("no instance of InProgress", app.getCurrentState() instanceof InProgress);
		app.reply();
		Assert.assertTrue("no instance of Replied", app.getCurrentState() instanceof Replied);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	public void testInterviewAfterReply() {
		Assert.assertTrue("no instance of InProgress", app.getCurrentState() instanceof InProgress);
		app.interview();
		Assert.assertTrue("no instance of Invited", app.getCurrentState() instanceof Invited);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	public void testInterview() {
		Assert.assertTrue("no instance of InProgress", app.getCurrentState() instanceof InProgress);
		app.interview();
		Assert.assertTrue("no instance of Invited", app.getCurrentState() instanceof Invited);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	public void testRefuse() {
		Assert.assertTrue("no instance of InProgress", app.getCurrentState() instanceof InProgress);
		app.refuse();
		Assert.assertTrue("no instance of Refused", app.getCurrentState() instanceof Refused);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	public void testRetract() {
		Assert.assertTrue("no instance of InProgress", app.getCurrentState() instanceof InProgress);
		app.retract();
		Assert.assertTrue("no instance of Retracted", app.getCurrentState() instanceof Retracted);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	private void testClose() {
		Assert.assertTrue("no instance of InProgress", app.getCurrentState() instanceof InProgress);
		app.close();
		Assert.assertTrue("no instance of Closed", app.getCurrentState() instanceof Closed);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());		
	}
}