package dev.uni.infrastructure.share;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class BaseExceptionResolver {

  private static final String CLASS = BaseExceptionResolver.class.getName();
  @ExceptionHandler(BaseException.class)
  public ResponseEntity<ErrorResponse> errorHandler(BaseException exception){
    log.error("{}::errorHandler --RipsException {}", CLASS,exception.getLocalizedMessage());
    return new ResponseEntity<>(ErrorResponse.builder().status(exception.getStatus()
                                              .value()).code(exception.getCode())
                                              .message(exception.getMessage())
                                              .date(exception.getDate().toString()).build(),
                                              HttpStatus.valueOf((exception.getStatus().value())));
  }

}
