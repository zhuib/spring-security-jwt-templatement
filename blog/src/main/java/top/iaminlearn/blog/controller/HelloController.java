package top.iaminlearn.blog.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 2022/5/15 18:19
 */

@RestController
@RequestMapping("/blog")
public class HelloController {

    @GetMapping("/hello")
//    @PreAuthorize("hasAuthority('system:dept:list')")
    @PreAuthorize("@ss.hasPermi('system:dept:list')")
    public String hello() {
        return "Hello World";
    }
}
