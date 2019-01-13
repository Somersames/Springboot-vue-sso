package somersames.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import somersames.constant.ApiConstant;
import somersames.constant.ResponseEnum;
import somersames.entity.UserInfo;
import somersames.service.AuthService;
import somersames.util.ResponseUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author szh
 * @create 2019-01-13 12:27
 **/
@RestController
@RequestMapping(ApiConstant.BASE_API)
@Slf4j
public class AuthController {

    @Autowired
    AuthService authService;

    @CrossOrigin("*")
    @PostMapping(value = ApiConstant.AUTH+"/{from}")
    public ResponseUtils<String> saveUserInfo(@PathVariable("from") String from, @RequestBody UserInfo userInfo, HttpServletResponse response){
        ResponseUtils<String> resp =new ResponseUtils<String>();
        String userId = authService.validUser(userInfo,from);
        if(StringUtils.isEmpty(userId)){
            ResponseEnum.FAIL.setResponse(resp);
            return resp;
        }else{
            ResponseEnum.SUCCESS.setResponse(resp);
            resp.setData(userId);
            response.addCookie(new Cookie("token",userId));
            return resp;
        }
    }
    @GetMapping(value = ApiConstant.AUTH)
    public ResponseUtils<String> saveUserInfo(){
        ResponseUtils<String> resp =new ResponseUtils<String>();
        ResponseEnum.SUCCESS.setResponse(resp);
        return resp;
    }
}
