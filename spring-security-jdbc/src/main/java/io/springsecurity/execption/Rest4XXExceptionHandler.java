package io.springsecurity.execption;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class Rest4XXExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleNoHandlerFoundException(ex, headers, status, request);
	}

	@ExceptionHandler(value = ResponseStatusException.class)
    public ResponseEntity<Object> handleResponseStatusException(final ResponseStatusException e, WebRequest wr) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        String message = e.getReason();
        if (!message.matches("^\\s*\\{.*\\}\\s*$")) {
            message = "\"" + message + "\"";
        }

        return handleExceptionInternal(e, "{\"message\": " + message + "}", headers, e.getStatus(), wr);
    }
	
	@ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(final AccessDeniedException e) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        // returns in same format as other 403 exceptions
        return new ResponseEntity("{  \"message\": \"" + e.getMessage() + "\" }", headers, HttpStatus.FORBIDDEN);
    }
}
