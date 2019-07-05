package de.juli.newjob.controller.aplaystate;

public class StateContext {
	protected static final State CREATE = new Created();
	protected static final State DOCUMENTS = new Documents();
	protected static final State IN_PROGRESS = new InProgress();
	protected static final State INVITED = new Invited();	
	protected static final State REFUSED = new Refused();	
	protected static final State REPLIED = new Replied();	
	protected static final State RETRACTED = new Retracted();	
	protected static final State SENDED = new Sended();	
	protected static final State STARTED = new Started();	
	protected static final State DELETED = new Deleted();
	protected static final State HIRED = new Hired();
	protected static final State RE_OPEN = new ReOpen();
	public static final State CLOSE = new Closed();
}
