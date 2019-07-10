package com.abolkog.springboot.tut.error;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.List;   //lazm adefha 3shan mst5dma list

@ControllerAdvice //to handle the exceptions globally
@RestController
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorDetails> handleApiExceptions(ApiBaseException ex, WebRequest request){
        ErrorDetails details = new ErrorDetails(ex.getMessage(), request.getDescription(false)); // ba3ml call lel class error details
        return new ResponseEntity<>(details, ex.getStatusCode());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
         ValidationDetails validationDetails = new ValidationDetails();
         validationDetails.setUri(request.getDescription(false));

         List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
         for (FieldError f: fieldErrors){
             validationDetails.addError(f.getDefaultMessage());
         }
         return new ResponseEntity<>(validationDetails ,HttpStatus.BAD_REQUEST);
    }

    //    @ExceptionHandler(value = ApiBaseException.class) // Exception handler to handle the specific exceptions and sending the custom responses to the client 3shan ttl3ly el msg "No record with the id (%s) was found in our database"
//    public ResponseEntity<ErrorDetails> handleApiExceptions (ApiBaseException ex, WebRequest request){
//       ErrorDetails details = new ErrorDetails(ex.getMessage() , request.getDescription(false));
//       return new ResponseEntity(details , HttpStatus.INTERNAL_SERVER_ERROR); // shelna el ngeb el object kolo
//    }
//
//        @ExceptionHandler(value = Exception.class)
//        protected ResponseEntity<ErrorDetails> handleMissingServletRequestParameterExceptions(MissingServletRequestParameterException ex, WebRequest request) {
//            ErrorDetails details = new ErrorDetails(ex.getMessage() , request.getDescription(false));
//
//            return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
//        }


}
