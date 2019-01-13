package somersames.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author szh
 * @create 2019-01-13 14:41
 **/
@Table(name = "app_2")
@Data
public class OrderInfo extends BaseEntity{

    @Column(name = "user_id")
    private String userId;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "order_info")
    private String orderInfo;

    @Column(name = "address")
    private String address;
}
