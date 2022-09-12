package com.shf.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Login Response
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="LoginResponse", description="用户登录返回数据")
public class LoginResponse implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户登录密钥")
    private String token;

    @ApiModelProperty(value = "状态:login-登录，register-注册,start-注册起始页")
    private String type;

    @ApiModelProperty(value = "注册key")
    private String key;

    @ApiModelProperty(value = "登录用户Uid")
    private Integer uid;

    @ApiModelProperty(value = "登录用户昵称")
    private String nikeName;

    @ApiModelProperty(value = "登录用户手机号")
    private String phone;
}
