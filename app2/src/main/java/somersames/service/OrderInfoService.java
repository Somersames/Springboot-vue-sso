package somersames.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import somersames.dao.OrderInfoDao;
import somersames.entity.OrderInfo;
import somersames.entity.UserLoginInfo;
import somersames.exception.TokenVaildException;

import java.util.List;

/**
 * @author szh
 * @create 2019-01-13 14:48
 **/
@Service
public class OrderInfoService {

    @Autowired
    RedisService redisService;

    @Autowired
    OrderInfoDao orderInfoDao;

    public List<OrderInfo> queryUserOrderInfo(String token ){
        UserLoginInfo userLoginInfo = redisService.getUserLoginInfobyId(token);
        String userId = null;
        if(userLoginInfo != null){
            userId = userLoginInfo.getUserId();
            return orderInfoDao.queryOrderInfoList(userId);
        }else{
            throw new TokenVaildException("无效token");
        }
    }
}
