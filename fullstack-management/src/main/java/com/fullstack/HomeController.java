package com.fullstack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangcolin
 */
@RestController
@RequestMapping("/home")
@Slf4j
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "Welcome";
    }
}
