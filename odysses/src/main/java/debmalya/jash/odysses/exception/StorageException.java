package debmalya.jash.odysses.exception;

public class StorageException extends RuntimeException {

  /** */
  private static final long serialVersionUID = -6544268021197137294L;

  public StorageException(String message) {
    super(message);
  }

  public StorageException(String message, Throwable cause) {
    super(message, cause);
  }
}
