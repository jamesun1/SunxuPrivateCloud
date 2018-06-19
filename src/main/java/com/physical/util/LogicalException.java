package com.physical.util;

/**
 * 消息异常类
 * 
 * @author SUN
 *
 */
public class LogicalException extends Exception {

	private static final long serialVersionUID = 1L;

	public LogicalException() {
		super();
	}

	public LogicalException(String message) {
		super(message);
	}

	public LogicalException(Throwable cause) {
		super(cause);
	}

	public LogicalException(String message, Throwable cause) {
		super(message, cause);
	}
}
