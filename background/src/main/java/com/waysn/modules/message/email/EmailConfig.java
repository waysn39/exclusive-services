/**
 * Copyright (c) 2018 waysn All rights reserved.
 * <p>
 * <p>
 * 版权所有，侵权必究！
 */

package com.waysn.modules.message.email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 邮件配置信息
 *
 * @author jinyiming waysn39@hotmail.com
 */
@ApiModel(value = "邮件配置信息")
public class EmailConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "SMTP")
    @NotBlank(message = "{email.smtp.require}")
    private String smtp;

    @ApiModelProperty(value = "端口号")
    @NotNull(message = "{email.port.require}")
    private Integer port;

    @ApiModelProperty(value = "邮箱账号")
    @NotBlank(message = "{email.username.require}")
    private String username;

    @ApiModelProperty(value = "邮箱密码")
    @NotBlank(message = "{email.password.require}")
    private String password;

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}