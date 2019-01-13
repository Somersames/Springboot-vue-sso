package somersames.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import somersames.dao.UserLoginDao;
import somersames.entity.UserInfo;
import somersames.entity.UserLoginInfo;

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

    public String validUser(UserInfo userInfo,String from){
        UserInfo user = userLoginDao.validUserInfo(userInfo);
        if(user == null){
            return null;
        }else{
            UserLoginInfo userLoginInfo = redisService.getUserInfoById(user.getUserId());
            if(userLoginInfo != null){
                return userLoginInfo.getUserId();
            }
            redisService.saveUserInfoToRedis(user,from);
            return user.getUserId();
        }
    }
}