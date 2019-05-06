package com.netstudy.common.utils.config;

import com.netstudy.common.bean.Remarks;
import com.netstudy.common.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Remarks("创建UserRealm")
    @Bean("userRealm")
    public UserRealm getUserRealm() {

        return new UserRealm();
    }

    @Remarks("创建DefaultWebSecurityManager")
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Remarks("创建ShiroFilterFactoryBean")
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> fileMaps = new HashMap<>();
        filterFactoryBean.setLoginUrl("/toLogin");
        filterFactoryBean.setFilterChainDefinitionMap(fileMaps);
        return filterFactoryBean;
    }
}
