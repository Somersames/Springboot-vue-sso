package somersames.util;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.http.Cookie;

/**
 * @author szh
 * @create 2019-01-13 16:26
 **/
public class CookiesUtil {
    public static String getToken (HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length !=0){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("token")){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
