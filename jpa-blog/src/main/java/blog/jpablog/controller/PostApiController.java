package blog.jpablog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.jpablog.exception.CustomException;
import blog.jpablog.exception.ErrorCode;

@RestController
@RequestMapping("/api")
public class PostApiController {

  // 강제로 오류 발생
  @GetMapping("/test")
  public String test() {
    //throw new CustomException(ErrorCode.INTERNAL_SERVER_ERROR);
    throw new CustomException(ErrorCode.BAD_REQUEST);
  }
  
}
