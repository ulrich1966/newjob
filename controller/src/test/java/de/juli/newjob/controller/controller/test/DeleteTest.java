package de.juli.newjob.controller.controller.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.juli.newjob.controller.aplaystate.Deleted;
import de.juli.newjob.controller.aplaystate.Documents;
import de.juli.newjob.controller.aplaystate.Started;
import de.juli.newjob.controller.controller.Application;
import de.juli.newjob.recource.tools.PrettyLog;

public class DeleteTest {
	private static final Logger LOG = LoggerFactory.getLogger(DeleteTest.class);
	private static final PrettyLog LOG_P = new PrettyLog(LOG);

	private static Application app;

	@Test
	public void testAppDocuments() {
		app = new Application();
		app.setCurrentState(new Deleted());
		testDocuments();
	}

	@Test
	public void testAppStart() {
		app = new Application();
		app.setCurrentState(new Deleted());
		testStart();
	}

	private void testDocuments() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Deleted);
		app.documents();
		Assert.assertTrue("no instance of Documents", app.getCurrentState() instanceof Documents);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
		
	}

	private void testStart() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Deleted);
		app.start();
		Assert.assertTrue("no instance of ReOpen", app.getCurrentState() instanceof Started);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
		
	}
}