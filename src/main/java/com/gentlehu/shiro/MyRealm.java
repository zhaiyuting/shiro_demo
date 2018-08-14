package com.gentlehu.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by DELL on 2018/8/13.
 */
public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String currentUsername = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if(currentUsername != null && currentUsername.equals("admin")){
            authorizationInfo.addRole("admin");

            authorizationInfo.addStringPermission("admin:manage");
            return authorizationInfo;
        }
        return authorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        if("admin".equals(token.getUsername())){
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("admin","admin",this.getName());
            SecurityUtils.getSubject().getSession().setAttribute("currentUser","admin");
            return authenticationInfo;
        }else if("user".equals(token.getUsername())){
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("user","user",this.getName());
            SecurityUtils.getSubject().getSession().setAttribute("currentUser","user");
            return authenticationInfo;
        }
        return null;
    }
}
