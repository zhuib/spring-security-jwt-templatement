package top.iaminlearn.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.iaminlearn.blog.entity.User;

/**
 * Date: 2022/5/15 21:20
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
