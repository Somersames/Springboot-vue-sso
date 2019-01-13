package somersames.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author szh
 * @create 2019-01-13 12:44
 **/
@Data
public class UserLoginInfo{

    private String userId;

    private String loginFrom;

    private Date loginTime;
}
