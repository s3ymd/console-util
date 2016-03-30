package jp.co._3sss.console_util;

public class ConsoleException extends RuntimeException {

  private static final long serialVersionUID = 1567106690000697727L;

  public ConsoleException() {
    super();
  }

  public ConsoleException(String message) {
    super(message);
  }

  public ConsoleException(Throwable cause) {
    super(cause);
  }

  public ConsoleException(String message, Throwable cause) {
    super(message, cause);
  }

}