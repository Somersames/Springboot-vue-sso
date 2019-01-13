package somersames.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author szh
 * @create 2019-01-13 12:57
 **/
@Data
@Table(name = "sso_user_info")
public class UserInfo extends BaseEntity {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

}
