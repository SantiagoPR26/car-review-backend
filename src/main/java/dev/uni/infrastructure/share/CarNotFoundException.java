package dev.uni.infrastructure.share;

import org.springframework.http.HttpStatus;

public class CarNotFoundException extends BaseException{
  public CarNotFoundException(String message){
    super(false, HttpStatus.NOT_FOUND, message, ExceptionCode.CAR_NOT_FOUND);
  }

}
