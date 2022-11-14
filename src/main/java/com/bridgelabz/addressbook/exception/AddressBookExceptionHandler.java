package com.bridgelabz.addressbook.exception;

import com.bridgelabz.addressbook.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class AddressBookExceptionHandler {

    @ExceptionHandler(AddressBookException.class)
    public ResponseEntity<ResponseDTO> handleAddressBookException(AddressBookException exception) {
        log.info("Inside handleAddressBookException()");
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request",
                exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException (MethodArgumentNotValidException exception) {
        log.info("Inside handleMethodArgumentNotValidException()");
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request", errMsg);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseDTO> handleMethodDataIntegrityViolationException(DataIntegrityViolationException exception) {
        ResponseDTO responseDTO = new ResponseDTO("Duplicate Phone Number Entry!!!", exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.LOCKED);
    }
}