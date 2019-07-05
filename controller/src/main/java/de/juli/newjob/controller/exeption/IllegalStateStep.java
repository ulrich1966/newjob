package de.juli.newjob.controller.exeption;

public class IllegalStateStep extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IllegalStateStep() {
		super();
	}

	public IllegalStateStep(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalStateStep(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalStateStep(String message) {
		super(message);
	}

	public IllegalStateStep(Throwable cause) {
		super(cause);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
	}

}
