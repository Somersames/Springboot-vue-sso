package somersames.dao;

import org.springframework.beans.factory.annotation.Autowired;
import somersames.entity.BaseEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

/**
 * @author szh
 * @create 2019-01-13 12:52
 **/
public abstract class AbstractDao<T extends BaseEntity> {

    @Autowired
    Mapper<T> mapper;

    public T selectByDto(T t){
        return  mapper.selectOne(t);
    }

    public T create(T t){
        Date now = new Date();
        t.setCreatedTime(now);
        t.setUpdatedTime(now);
        return t;
    }
}
