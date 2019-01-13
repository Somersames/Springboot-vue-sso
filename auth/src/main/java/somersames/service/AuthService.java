package somersames.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import somersames.dao.UserLoginDao;
import somersames.entity.UserInfo;
import somersames.entity.UserLoginInfo;
import somersames.util.JWTUtil;
import somersames.util.MD5Util;

/**
 * @author szh
 * @create 2019-01-13 12:28
 **/
@Service
public class AuthService {

    @Autowired
    UserLoginDao userLoginDao;

    @Autowired
    RedisService redisService;

    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    MD5Util md5Util;

    public String validUser(UserInfo userInfo,String from){
        UserInfo user = userLoginDao.validUserInfo(userInfo);
        if(user == null){
            return null;
        }else{
//            String token = jwtUtil.createJWT(user.getUserId());
            String token = md5Util.md5Password(user.getUserId());
            UserLoginInfo userLoginInfo = redisService.getUserInfoById(token);
            if(userLoginInfo != null){
                return token;
            }
            redisService.saveUserInfoToRedis(user,from,token);
            return token;
        }
    }
}
