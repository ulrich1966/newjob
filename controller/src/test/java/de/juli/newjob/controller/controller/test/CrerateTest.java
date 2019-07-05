package de.juli.newjob.controller.controller.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.juli.newjob.controller.aplaystate.Created;
import de.juli.newjob.controller.aplaystate.Deleted;
import de.juli.newjob.controller.aplaystate.Documents;
import de.juli.newjob.controller.aplaystate.State;
import de.juli.newjob.controller.controller.Application;
import de.juli.newjob.recource.tools.PrettyLog;

public class CrerateTest {
	private static final Logger LOG = LoggerFactory.getLogger(CrerateTest.class);
	private static final PrettyLog LOG_P = new PrettyLog(LOG);

	private static Application app;

	@Test
	public void testAppDocuments() {
		app = new Application();
		app.setCurrentState(new Created());
		testDocuments();
	}

	@Test
	public void testAppDelete() {
		app = new Application();
		app.setCurrentState(new Created());
		testDelete();
	}

	public void testDocuments() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Created);
		app.documents();
		State state = app.getCurrentState();
		Assert.assertTrue("no instance of Documents", state instanceof Documents);
		LOG_P.info("current state", state.getClass().getSimpleName());
	}

	private void testDelete() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Created);
		app.delete();
		Assert.assertTrue("no instance of Delete", app.getCurrentState() instanceof Deleted);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}
}