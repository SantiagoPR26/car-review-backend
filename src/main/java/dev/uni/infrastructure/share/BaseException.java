package dev.uni.infrastructure.share;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Getter
public abstract class BaseException extends RuntimeException{

  private static final long seriolVersionUID = -8269011351784691L;
  private final boolean retryable;
  private final HttpStatus status;
  private final String code;
  private final String message;
  private final LocalDateTime date;
  private final ExceptionCode exceptionCode;
  private Throwable cause;
  private final String id = UUID.randomUUID().toString();

  protected BaseException(boolean retryable, HttpStatus status, String message, ExceptionCode exceptionCode) {
    this.retryable = retryable;
    this.code = exceptionCode.getCode();
    this.message = message;
    this.status = status;
    this.exceptionCode = exceptionCode;
    this.date = LocalDateTime.now(ZoneId.systemDefault());
  }

  protected BaseException(boolean retryable, HttpStatus status, String message, ExceptionCode exceptionCode, Throwable cause) {
    this.retryable = retryable;
    this.code = exceptionCode.getCode();
    this.message = message;
    this.status = status;
    this.exceptionCode = exceptionCode;
    this.cause = cause;
    this.date = LocalDateTime.now(ZoneId.systemDefault());
  }

  protected BaseException(boolean retryable, String message, ExceptionCode exceptionCode, Throwable cause){
    this.retryable = retryable;
    this.code = exceptionCode.getCode();
    this.message = message;
    this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    this.exceptionCode = exceptionCode;
    this.cause = cause;
    this.date = LocalDateTime.now(ZoneId.systemDefault());
  }


}
