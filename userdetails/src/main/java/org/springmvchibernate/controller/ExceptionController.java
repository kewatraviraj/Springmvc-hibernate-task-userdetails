package org.springmvchibernate.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

//@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Resource Not Found") // 404
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleError404(HttpServletRequest request, Exception e) {
		Logger.getLogger(getClass().getName()).log(Level.WARN, "Request: " + request.getRequestURL() + " raised " + e);
		return "error";
	}
}
