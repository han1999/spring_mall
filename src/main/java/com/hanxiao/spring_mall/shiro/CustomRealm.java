package com.hanxiao.spring_mall.shiro;

import com.hanxiao.spring_mall.bean.Admin;
import com.hanxiao.spring_mall.bean.AdminExample;
import com.hanxiao.spring_mall.mapper.AdminMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/28
 **/
@Component
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    AdminMapper adminMapper;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();


        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Admin> admins = adminMapper.selectByExample(example);
        if (admins == null || admins.isEmpty()) {
            return null;
        }
        Admin admin = admins.get(0);
        String credential = admin.getPassword();
        return new SimpleAuthenticationInfo(admin, credential, getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Admin primaryPrincipal = (Admin) principals.getPrimaryPrincipal();
        Integer id = primaryPrincipal.getId();

        List<String> permissions = queryFromDb(id);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    private List<String> queryFromDb(Integer id) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("admin:user:list");
        strings.add("hanxiao:user");
        return strings;
    }
}
