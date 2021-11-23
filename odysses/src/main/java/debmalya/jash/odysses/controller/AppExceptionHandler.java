package debmalya.jash.odysses.controller;

import debmalya.jash.odysses.exception.StorageException;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class AppExceptionHandler {

  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
  public ResponseEntity<Object> handleNoHandlerFound(Exception exception, WebRequest request) {
    HashMap<String, String> body = new HashMap<>();
    body.put("message", "invalid endpoint");
    return new ResponseEntity<>(body, HttpStatus.METHOD_NOT_ALLOWED);
  }

  @ExceptionHandler(StorageException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<Object> invalidParameter(Exception exception, WebRequest request) {
    HashMap<String, String> body = new HashMap<>();
    body.put("message", exception.getMessage());
    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }
}
