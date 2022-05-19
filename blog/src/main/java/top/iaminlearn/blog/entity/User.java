package top.iaminlearn.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Date: 2022/5/15 20:56
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User {
    private static final long serialVersionUID = 1L;

    // 主键
    private Long id;
    @TableField("user_name")
    private String username;
    @TableField("nick_name")
    private String nickname;
    private String password;
    private String status; // 账号状态（0 正常，1 停用）
    private String email;
    private String phone; // 头像
    private String sex; // (0 男 ，1 女 2 未知)
    private String avatar; // 头像
    private String userType; // 0 管理员 1 普通用户
    private Long createBy; // 创建人用户id
    private Date createTime;
    private Long updateBy; // 更新人用户id
    private Date updateTime;
    private String delFlag; // 删除标记（0 正常，1 删除）

    @TableField(exist = false)
    private List<Role> roles;

}
