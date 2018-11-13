package com.stylefeng.guns.rest.common;/**
 * Created by misdeadgirl on 2018/11/13.
 */

import com.stylefeng.guns.api.user.UserInfoModel;

/**
 * @author
 * @create 2018-11-13 下午3:16
 **/
public class CurrentUser {

    public static final ThreadLocal<UserInfoModel> threadLocal = new ThreadLocal<>();

    public static void saveUserInfo(UserInfoModel userInfoModel){
        threadLocal.set(userInfoModel);
    }

    public static UserInfoModel getCurrentUser(){
        return threadLocal.get();
    }
}
