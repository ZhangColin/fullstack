package com.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangcolin
 */
@SpringBootApplication
public class FullStackManagementApplication {
    public static void main(String[] args) {
        // 启动Spring应用
        SpringApplication.run(FullStackManagementApplication.class, args);

        User user = new User("colin", "123456");
        String name = user.getName();

    }
}
