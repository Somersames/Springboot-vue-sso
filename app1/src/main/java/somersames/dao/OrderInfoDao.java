package somersames.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import somersames.entity.OrderInfo;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author szh
 * @create 2019-01-13 14:44
 **/
@Component
public class OrderInfoDao extends AbstractDao<OrderInfo> {

    @Autowired
    Mapper<OrderInfo> mapper;


    public List<OrderInfo> queryOrderInfoList(String userId){
        Example example = new Example(OrderInfo.class);
        Example.Criteria criteria =example.createCriteria();
        criteria.andEqualTo("userId",userId);
        return mapper.selectByExample(example);
    }
}
