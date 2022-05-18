package blog.jpablog.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

  // final 수정할 수 없음. 그러므로 초기값 필수,
  // 객체를 참조할때는 내부값은 변경될수 있음. 가리키는 객체는 변경안됨.
  private final LocalDateTime timestamp = LocalDateTime.now();
  private final int status;
  private final String error;
  private final String code;
  private final String message;

  // public ErrorResponse(ErrorCode errorCode) {
  //   this.status = errorCode.getStatus().value();
  //   this.error = errorCode.getStatus().name();
  //   this.code = errorCode.name();
  //   this.message = errorCode.getMessage();
  // }

  public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode errorCode) {
    return ResponseEntity
        .status(errorCode.getStatus())
        .body(ErrorResponse.builder()
            .status(errorCode.getStatus().value())
            .error(errorCode.getStatus().name())
            .code(errorCode.name())
            .message(errorCode.getMessage())
            .build());
  }

}
