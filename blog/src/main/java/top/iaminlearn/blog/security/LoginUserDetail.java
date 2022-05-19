package top.iaminlearn.blog.security;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import top.iaminlearn.blog.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Date: 2022/5/15 21:18
 */

@Data
@NoArgsConstructor
public class LoginUserDetail implements UserDetails {
    /**
     * 登陆时间
     */
    private Long loginTime;
    private String token;
    /**
     * 过期时间
     */
    private Long expireTime;

    private User user;

    private Set<String> permissions;

    public LoginUserDetail(User user, Set<String> permission) {
        this.user = user;
        this.permissions = permission;
    }

    @JSONField(serialize = false) // 该字段不能进行序列化，redis 不能将之进行序列化，获取权限信息 直接从permissions 中反序列化获取
    private Set<SimpleGrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities != null) {
            return authorities;
        }
//        return permission.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String permission : permissions) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission);
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
