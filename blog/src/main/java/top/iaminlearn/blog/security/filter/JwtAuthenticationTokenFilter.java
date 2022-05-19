package top.iaminlearn.blog.security.filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import top.iaminlearn.blog.security.LoginUserDetail;
import top.iaminlearn.blog.security.service.TokenService;
import top.iaminlearn.blog.util.RedisCache;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 *
 请求前进行一次过滤
 实现认证
 */

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;
    @Autowired
    private TokenService tokenService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取token 解析
        LoginUserDetail userDetail = tokenService.getLoginUser(request);
        if (Objects.isNull(userDetail)) {
            filterChain.doFilter(request, response); // 直接放行，不只一个 过滤器
            return; // 防止 过滤返回时，执行 if 之后的代码
        }
        // 从redis 中获取用户信息
        String redisKey = "login:" + userDetail.getUser().getId();
        LoginUserDetail loginUser = redisCache.getCacheObject(redisKey);
        if (Objects.isNull(loginUser)) {
            throw new RuntimeException("用户未登录~");
        }
        // 存入SecurityContextHolder
        // authorities 权限
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
