package somersames.entity;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author szh
 * @create 2019-01-13 12:54
 **/
@Data
public class BaseEntity {
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "updated_time")
    private Date updatedTime;

    @Column(name = "created_from")
    private String createdFrom;

    @Column(name = "updated_from")
    private String updatedFrom;

}
