package com.stylefeng.guns.rest.common;/**
 * Created by misdeadgirl on 2018/11/13.
 */

import com.stylefeng.guns.api.user.UserInfoModel;

/**
 * @author
 * @create 2018-11-13 下午3:16
 **/
public class CurrentUser {

    public static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    //使用userId降低存储压力
//    public static void saveUserInfo(UserInfoModel userInfoModel){
//        threadLocal.set(userInfoModel);
//    }
//
//    public static UserInfoModel getCurrentUser(){
//        return threadLocal.get();
//    }
    public static void saveUserId(String userId){
        threadLocal.set(userId);
    }

    public static String getUserId(){
        return threadLocal.get();
    }

}
