package com.stylefeng.guns.api.user;

import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.api.user.vo.UserModel;

/**
 * Created by misdeadgirl on 2018/11/8.
 */
public interface UserAPI {

    int userLogin(String username, String password);

    boolean register(UserModel userModel);

    boolean checkUsername(String username);

    UserInfoModel getUserInfo(String uuid);

    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);
}
