package somersames.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import somersames.entity.UserLoginInfo;

import javax.annotation.Resource;

/**
 * @author szh
 * @create 2019-01-13 14:46
 **/
@Service
public class RedisService {
    @Resource
    RedisTemplate<String,UserLoginInfo> redisTemplate;

    public UserLoginInfo getUserLoginInfobyId(String id){
        return redisTemplate.opsForValue().get("qwrwqrwqrqwrqr");
    }


}
