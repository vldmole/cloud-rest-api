package learning.java.bankApp.restApi.error;

import jakarta.validation.ConstraintViolationException;
import learning.java.bankApp.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ErrorResponse
                .builder(e, ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                        "Erro de validação de dados:" + e.getMessage()))
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResponse ConstraintViolationException(ConstraintViolationException e) {
        return ErrorResponse
                .builder(e, ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                        "Erro de validação de dados: " + e.getMessage()))
                .build();
    }

    @ExceptionHandler(ApplicationException.class)
    public ErrorResponse ApplicationException(ApplicationException e) {
        return ErrorResponse
                .builder(e, ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Erro da Aplicação: "+ e.getMessage()))
                .build();
    }

    @ExceptionHandler(Throwable.class)
    public ErrorResponse Throwable(Throwable e) {
        return ErrorResponse
                .builder(e, ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR))
                .build();
    }
}
