package top.iaminlearn.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 * Date: 2022/5/16 2:17
 */

@Data
public class Role {

    private Integer id;
    private String name;
    private String roleKey;
    private String status;
    private Integer delFlag;
    private Long creatBy;
    private Date creatTime;
    private Long updateBy;
    private Date updateTime;
    private String remark;

}
