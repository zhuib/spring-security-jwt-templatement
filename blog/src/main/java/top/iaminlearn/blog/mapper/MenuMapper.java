package top.iaminlearn.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.iaminlearn.blog.entity.Menu;

import java.util.List;
import java.util.Set;

/**
 * Date: 2022/5/16 0:51
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    Set<String> selectPermsByUserId(Long id);

}
