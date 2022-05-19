package top.iaminlearn.blog.security.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.iaminlearn.blog.security.LoginUserDetail;
import top.iaminlearn.blog.entity.User;
import top.iaminlearn.blog.mapper.MenuMapper;
import top.iaminlearn.blog.mapper.UserMapper;

import java.util.Objects;
import java.util.Set;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO:   根据用户名查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User user = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(user)) {
           throw  new RuntimeException("用户不存在");
        }
        // TODO:   权限
//        List<String> permissions = new ArrayList<>(Arrays.asList("test","admin"));
        Set<String> permissionKeyList =  menuMapper.selectPermsByUserId(user.getId());
        return new LoginUserDetail(user,permissionKeyList);
    }
}
