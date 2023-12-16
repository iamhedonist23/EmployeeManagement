package com.scaletech.com.employeeManagement.exceptionHanlder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.scaletech.com.employeeManagement.exceptionHanlder.exceptions.AgeIsNotCompltedException;
import com.scaletech.com.employeeManagement.exceptionHanlder.exceptions.DepartmentAttachedAlreadyException;
import com.scaletech.com.employeeManagement.exceptionHanlder.exceptions.DepartmentNotExistException;
import com.scaletech.com.employeeManagement.exceptionHanlder.exceptions.EmailNotValidException;
import com.scaletech.com.employeeManagement.exceptionHanlder.exceptions.PhoneNotValidException;
import com.scaletech.com.employeeManagement.exceptionHanlder.exceptions.RoleAttachedAlreadyException;
import com.scaletech.com.employeeManagement.exceptionHanlder.exceptions.RoleIsNotExistException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({EmailNotValidException.class,PhoneNotValidException.class,AgeIsNotCompltedException.class,RoleAttachedAlreadyException.class,DepartmentAttachedAlreadyException.class,RoleIsNotExistException.class,DepartmentNotExistException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

