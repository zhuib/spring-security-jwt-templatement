package top.iaminlearn.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import top.iaminlearn.blog.constant.SysConstants;
import top.iaminlearn.blog.security.LoginUserDetail;
import top.iaminlearn.blog.entity.User;
import top.iaminlearn.blog.security.service.TokenService;
import top.iaminlearn.blog.service.LoginService;
import top.iaminlearn.blog.util.*;

import java.util.Objects;

/**
 * Date: 2022/5/15 21:52
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private TokenService tokenService;

    @Override
    public R login(User user) {

        // 对用进行认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);// 调用UserDetailService 中的的方法 进行验证
        if(Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败~");
        }

        LoginUserDetail loginUser = (LoginUserDetail)authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        // 生成token 返回
        String sign = tokenService.createToken(loginUser);
        //  保存登录信息到 redis 中
        redisCache.setCacheObject("login:"+userId,loginUser);
        return R.success().add("Authorization", SysConstants.TOKEN_PREFIX+sign);
    }

/*    // 可以直接实现 登录 处理类 就不用手动处理登出方式
    @Override
    public R logout() {
        // 获取SecurityContextHolder 中的用户id
        // 这里能够获取 userID 是 请求过来时，会先经过 JwtAuthenticationTokenFilter 过滤器
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUserDetail loginUser = (LoginUserDetail) authentication.getPrincipal();
        Long userId = loginUser.getUser().getId();
        // 删除 redis
        redisCache.deleteObject("login:"+userId);
        return R.success(ReturnCodeEnum.LOGOUT);
    }*/
}
