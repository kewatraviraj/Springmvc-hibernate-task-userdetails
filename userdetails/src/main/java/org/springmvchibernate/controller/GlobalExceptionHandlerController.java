package org.springmvchibernate.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandlerController {

	private static final Logger _log = Logger.getLogger(GlobalExceptionHandlerController.class.getName());
	
	@ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ModelAndView exceptionHandler() {
        _log.info("exceptionHandlerFor404");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        mav.addObject("message", "some error");
        mav.setStatus(HttpStatus.NOT_FOUND);

        return mav;
    }
	
/*	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle(NoHandlerFoundException ex) {
		_log.info("response of no handler found");
		return "error";
	}*/
	/*
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest request, Exception e)   {
     //   Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Request: " + request.getRequestURL() + " raised " + e);
    	_log.error("Page Not Found");
        return new ModelAndView("error");
    }

	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
     //   Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Request: " + request.getRequestURL() + " raised " + e);
		_log.error("Handler Not Found");
		return new ModelAndView("error");
	}*/
	
	/*@ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<String> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        // prepare responseEntity
		_log.info("No Handler Found");
        return ResponseEntity.ok().body("error");
    }*/
	
}
