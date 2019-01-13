package somersames.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import somersames.exception.TokenVaildException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author szh
 * @create 2019-01-13 14:21
 **/
public class InterceptConfig  implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if("OPTIONS".equals(request.getMethod())){
            return true;
        }
        if(request.getRequestURI().contains("api/app2/query")){
            return true;
        }
        Cookie[] token = request.getCookies();
        if(token != null && token.length !=0){
            for(Cookie cookie :token){
                if(cookie.getName().equals("token")){
                    return true;
                }
            }
        }
         throw new TokenVaildException("请前往auth进行验证");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
