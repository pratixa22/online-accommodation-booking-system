package com.sunbeam.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sunbeam.models.Response;

@ControllerAdvice
public class RestControllerExceptionHandlerImpl {
	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
		// either use map for returning multiple values
//		Map<String, Object> map = new HashMap<>();
//		map.put("status", "error");
//		map.put("error", ex.getMessage());
		// or create pojo class for the same
			// class MyError {
			//		private String status;
			//		private String error;
			//		// getter/setter
			// }
			//return ResponseEntity.ok(new MyError("error", ex.getMessage()));
		return Response.error(ex.getMessage());
	}
}
