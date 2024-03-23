package com.fullstack.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangcolin
 */
@RestController
@RequestMapping("/users")
@Slf4j
@Api(tags = "用户管理")
public class UserController {
    private static List<User> dbUsers = new ArrayList<User>() {{
        add(new User(1, "colin", "zhang_colin"));
        add(new User(2, "emily", "hu_emily"));
    }};

    @GetMapping
    @ApiOperation(value = "获取所有用户", notes = "获取所有用户的描述，告诉你怎么使用这个接口")
    public List<User> getAllUsers() {
        return dbUsers;
    }

    @PostMapping("/search")
    @ApiOperation(value = "搜索用户")
    public List<User> search(@RequestBody UserSearchParam search){
        return dbUsers.stream()
                .filter(user -> user.getUserName()
                        .contains(search.getUserName())).collect(Collectors.toList());
    }


    @GetMapping("/{userId}")
    @ApiOperation(value = "获取指定用户")
    public User getUserById(@ApiParam(name = "userId", value = "用户的Id") @PathVariable(value = "userId") Integer id){
        return dbUsers.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    @PostMapping
    @ApiOperation(value = "创建用户")
    public Integer create(@RequestBody User user) {
        user.setId(dbUsers.size()+1);
        dbUsers.add(user);

        return user.getId();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新用户")
    public Integer update(@ApiParam("需要更新的用户的Id") @PathVariable Integer id, @RequestBody User user) {
        User dbUser = dbUsers.stream().filter(u -> u.getId().equals(id)).findFirst().get();

        dbUser.setUserName(user.getUserName());
        dbUser.setNickName(user.getNickName());

        // access db

        return dbUser.getId();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户")
    public String delete(@PathVariable Integer id){
        dbUsers.remove(dbUsers.stream().filter(u -> u.getId().equals(id)).findFirst().get());

        return "Success";
    }

    @PutMapping("/{id}/enable")
    public String enable(@PathVariable Integer id){
        // get user
        // set user enable
        return "success";
    }

    @PutMapping("/{id}/disable")
    public String disable(@PathVariable Integer id){
        // get user
        // set user disable
        return "success";
    }
}
