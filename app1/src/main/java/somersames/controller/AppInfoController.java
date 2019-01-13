package somersames.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import somersames.constant.ApiConstant;
import somersames.constant.ResponseEnum;
import somersames.util.ResponseUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author szh
 * @create 2019-01-13 14:27
 **/

@RestController
@RequestMapping(ApiConstant.BASE_API)
@Slf4j
public class AppInfoController {

    @GetMapping(ApiConstant.APP+"/{token}")
    public ResponseUtils getInfo(@PathVariable String token , HttpServletResponse response){
        ResponseUtils<String> resp = new ResponseUtils<String>();
        ResponseEnum.SUCCESS.setResponse(resp);
        response.addCookie(new Cookie("token",token));
        return resp;
    }
}
