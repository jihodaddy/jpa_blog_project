package blog.jpablog.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.resource.HttpResource;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice //Controller 전역에서 발생할 수 있는 예외를 잡아 Throw
//Controller에 ResponseBody 적용된 형태라 보면 됨
@Slf4j
public class GlobalExceptionHandler {
  
  @ExceptionHandler(value = { CustomException.class })
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }


  //  Custom Exception
//   @ExceptionHandler(RuntimeException.class) // 특정 클래스 발생할 수 있는 예외 잡아 Throw
//   public ResponseEntity<ErrorResponse> handleRuntimeException(final CustomException e) {
//     log.error("handleCustomException: {}", e.getErrorCode());
//     return ResponseEntity
//         .status(e.getErrorCode().getStatus().value())
//         .body(new ErrorResponse(e.getErrorCode()));
//   }

//   @ExceptionHandler(NotFoundException.class)
//   public ResponseEntity<ErrorResponse> handleStatusException(final CustomException e) {
//     log.error("handleCustomException: {}", e.getMessage());
//     return ResponseEntity
//             .status(ErrorCode.POSTS_NOT_FOUND.getStatus().value())
//             .body(new ErrorResponse(e.getErrorCode()));
//   }

// /*   
//  * HTTP 405 Exception
//  */
//   @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//   protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(
//       final HttpRequestMethodNotSupportedException e) {
//     log.error("handleHttpRequestMethodNotSupportedException: {}", e.getMessage());
//     return ResponseEntity
//         .status(ErrorCode.METHOD_NOT_ALLOWED.getStatus().value())
//         .body(new ErrorResponse(ErrorCode.METHOD_NOT_ALLOWED));
//   }
//  /* 
//  * HTTP 500 Exception
//  */
//   @ExceptionHandler(Exception.class)
//   protected ResponseEntity<ErrorResponse> handleException(final Exception e) {
//     log.error("handleException: {}", e.getMessage());
//     return ResponseEntity
//               .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus().value())
//         .body(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR));
//   }
  
}
