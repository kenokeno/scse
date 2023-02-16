package mx.edu.itspa.esgi.scse.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import mx.edu.itspa.esgi.scse.model.Response;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<Response> handleMaxSizeException(MaxUploadSizeExceededException ex) {
		System.out.println(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Verifica el tamaño de los archivos"));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handleException(Exception ex) {
		System.out.println(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(ex.getMessage()));
	} 
}
