package com.fullstack.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserSearchParam {
    private Integer pageSize;
    private Integer current;

    @ApiModelProperty(value = "用户名", notes = "模糊搜索")
    private String userName;
    @ApiModelProperty(value = "昵称", notes = "模糊搜索")
    private String nickName;
}
