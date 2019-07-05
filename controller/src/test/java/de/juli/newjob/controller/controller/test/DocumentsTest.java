package de.juli.newjob.controller.controller.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.juli.newjob.controller.aplaystate.Deleted;
import de.juli.newjob.controller.aplaystate.Documents;
import de.juli.newjob.controller.aplaystate.Sended;
import de.juli.newjob.controller.controller.Application;
import de.juli.newjob.recource.tools.PrettyLog;

public class DocumentsTest {
	private static final Logger LOG = LoggerFactory.getLogger(DocumentsTest.class);
	private static final PrettyLog LOG_P = new PrettyLog(LOG);

	private static Application app;
	
	//{@link Sended}, {@link Deleted}

	@Test
	public void testAppSended() {
		app = new Application();
		app.setCurrentState(new Documents());
		testDelete();
	}

	@Test
	public void testAppDeleted() {
		app = new Application();
		app.setCurrentState(new Documents());
		testSend();
	}

	private void testSend() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Documents);
		app.send();
		Assert.assertTrue("no instance of Documents", app.getCurrentState() instanceof Sended);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
		
	}

	private void testDelete() {
		Assert.assertTrue("no instance of Created", app.getCurrentState() instanceof Documents);
		app.delete();
		Assert.assertTrue("no instance of ReOpen", app.getCurrentState() instanceof Deleted);
		LOG_P.info("current state", app.getCurrentState().getClass().getSimpleName());
		
	}
}