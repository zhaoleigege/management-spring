package cn.edu.bnuz.account.web;

import cn.edu.bnuz.domain.error.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 文件 AccountControllerExceptionHandler 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@ControllerAdvice
public class AccountControllerExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> illegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(new ErrorResponse("访问错误", ex.getMessage()));
    }
}
