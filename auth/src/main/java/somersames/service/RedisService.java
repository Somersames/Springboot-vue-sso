package somersames.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import somersames.entity.UserInfo;
import somersames.entity.UserLoginInfo;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author szh
 * @create 2019-01-13 12:28
 **/
@Service
public class RedisService {
    @Resource
    RedisTemplate<String,UserLoginInfo> redisTemplate;

    public void saveUserInfoToRedis(UserInfo userInfo,String from){
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setUserId(userInfo.getUserId());
        userLoginInfo.setLoginFrom(from);
        userLoginInfo.setLoginTime(new Date());
        redisTemplate.opsForValue().set(userInfo.getUserId(),userLoginInfo);
    }

    public UserLoginInfo getUserInfoById(String userId){
       return redisTemplate.opsForValue().get(userId);
    }
}
