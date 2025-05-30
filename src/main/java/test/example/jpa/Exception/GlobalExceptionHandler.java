package test.example.jpa.Exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import test.example.jpa.Exception.dto.ExceptionDto;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionDto> handleCustomException(CustomException e) {

        CustomExceptionType errorType = e.getType();
        log.atLevel(errorType.getLevel()).setCause(e).log(e.getMessage());
        return ResponseEntity
                .status(errorType.getStatus())
                .body(ExceptionDto.of("잘못된 접근입니다. " + e.desc, e.getType().getStatus().value()));
    }

    @ExceptionHandler
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        log.atLevel(Level.ERROR).setCause(e).log(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed Program Error! Unexpected RuntimeException");
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception e) {
        log.atLevel(Level.ERROR).setCause(e).log(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed Program Error! Unexpected Exception");
    }

}
