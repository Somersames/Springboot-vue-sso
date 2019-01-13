package somersames.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import somersames.constant.ResponseEnum;
import somersames.util.ResponseUtils;

/**
 * @author szh
 * @create 2019-01-13 14:33
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = TokenVaildException.class)
    public ResponseUtils<String> handleToken (){
        ResponseUtils<String> resp = new ResponseUtils<String>();
        ResponseEnum.AUTH_FAIL.setResponse(resp);
        return resp;
    }
}
