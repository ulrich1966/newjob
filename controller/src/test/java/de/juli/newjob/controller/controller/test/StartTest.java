package de.juli.newjob.controller.controller.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.juli.newjob.controller.aplaystate.Created;
import de.juli.newjob.controller.aplaystate.Deleted;
import de.juli.newjob.controller.aplaystate.Documents;
import de.juli.newjob.controller.aplaystate.InProgress;
import de.juli.newjob.controller.aplaystate.Sended;
import de.juli.newjob.controller.aplaystate.Started;
import de.juli.newjob.controller.aplaystate.State;
import de.juli.newjob.controller.controller.Application;
import de.juli.newjob.recource.tools.PrettyLog;

public class StartTest {
	private static final Logger LOG = LoggerFactory.getLogger(StartTest.class);
	private static final PrettyLog LOG_P = new PrettyLog(LOG);
	
	private static Application app;

	@Test
	public void testApplicationCreateStart() {
		app = new Application();
		testStart();
		testCreate();
		testDocuments();
		testSend();
		testInProgress();
	}

	@Test
	public void testApplicationInProgressRefused() {
		app = new Application();
		testStart();
		testCreate();
		testDocuments();
		testSend();
		testInProgress();
	}

	@Test
	public void testApplicationDelete() {
		app = new Application();
		testStart();
		testCreate();
		testDelete();
	}

	@Test
	public void testApplicationDeleteStart() {
		app = new Application();
		testStart();
		testCreate();
		testDelete();
		testStart();
	}

	

	public void testStart() {
		app.start();
		State state = app.getCurrentState();
		Assert.assertTrue("no instance of Started", state instanceof Started);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}
	
	
	public void testCreate() {
		Assert.assertTrue("no instance of Started", app.getCurrentState() instanceof Started);
		app.create();
		State state = app.getCurrentState();
		Assert.assertTrue("no instance of Created", state instanceof Created);
		LOG_P.info("current state", state.getClass().getSimpleName());
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

	public void testSend() {
		Assert.assertTrue("no instance of Documents", app.getCurrentState() instanceof Documents);
		app.send();
		Assert.assertTrue("no instance of Sended", app.getCurrentState() instanceof Sended);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	public void testInProgress() {
		Assert.assertTrue("no instance of Sended", app.getCurrentState() instanceof Sended);
		app.inProgress();
		Assert.assertTrue("no instance of InProgress", app.getCurrentState() instanceof InProgress);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	public void testReply() {
		app.reply();
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	public void testInterview() {
		app.interview();
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	public void testRefuse() {
		app.refuse();
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}

	public void testRetract() {
		app.refuse();
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
	}
}