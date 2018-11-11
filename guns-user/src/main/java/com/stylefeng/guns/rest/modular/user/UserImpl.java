package com.stylefeng.guns.rest.modular.user;/**
 * Created by misdeadgirl on 2018/11/8.
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.user.UserAPI;
import org.springframework.stereotype.Component;

/**
 * @author
 * @create 2018-11-08 上午10:23
 **/
@Component
@Service(interfaceClass = UserAPI.class)
public class UserImpl implements UserAPI{
    @Override
    public boolean userLogin(String username, String password) {
        System.out.println("dubbo service from userModule" + username +","+password);
        return false;
    }
}
