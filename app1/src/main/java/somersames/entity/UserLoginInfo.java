package somersames.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author szh
 * @create 2019-01-13 12:44
 **/
@Data
public class UserLoginInfo implements Serializable{

    private String userId;

    private String loginFrom;

    private Date loginTime;
}
