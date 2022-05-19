package top.iaminlearn.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.iaminlearn.blog.entity.User;
import top.iaminlearn.blog.service.LoginService;
import top.iaminlearn.blog.util.R;

/**
 * Date: 2022/5/15 21:53
 */

@RestController
@RequestMapping("/blog")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public R login(@RequestBody User user) {

        return loginService.login(user);
    }


//    @GetMapping("/logout")
//    public R logout() {
//        return loginService.logout();
//    }
}
