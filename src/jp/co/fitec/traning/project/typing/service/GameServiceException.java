package jp.co.fitec.traning.project.typing.service;

public class GameServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public GameServiceException() {}
	
	public GameServiceException(String message) {
		super(message);
	}
	
	public GameServiceException(Exception e) {
		super(e);
	}
	
	public GameServiceException(String message, Exception e) {
		super(message, e);
	}
	
}
