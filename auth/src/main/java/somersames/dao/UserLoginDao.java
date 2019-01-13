package somersames.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import somersames.dao.mapper.UserInfoMapper;
import somersames.entity.UserInfo;

/**
 * @author szh
 * @create 2019-01-13 12:52
 **/
@Component
public class UserLoginDao extends AbstractDao<UserInfo> {

    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfo validUserInfo(UserInfo userInfo){
        return selectByDto(userInfo);
    }
}
