/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.security.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * token
 *
 * @author Mark sunlightcs@gmail.com
 */
public class Oauth2Token implements AuthenticationToken {
    private String token;

    public Oauth2Token(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
