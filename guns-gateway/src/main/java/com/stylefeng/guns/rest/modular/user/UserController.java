package com.stylefeng.guns.rest.modular.user;/**
 * Created by misdeadgirl on 2018/11/15.
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.api.user.vo.UserModel;
import com.stylefeng.guns.rest.common.CurrentUser;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @create 2018-11-15 下午8:44
 **/

@RequestMapping("/user/")
@RestController
public class UserController {

    @Reference(interfaceClass = UserAPI.class)
    private UserAPI userAPI;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResponseVO register(UserModel userModel){
        //校验提交的用户名和密码
        if(userModel.getUsername() == null || userModel.getUsername().trim().length() == 0){
            return ResponseVO.serviceFail("用户名不能为空");
        }

        if(userModel.getPassword() == null || userModel.getPassword().trim().length() == 0){
            return ResponseVO.serviceFail("密码不能为空");
        }

        boolean isSuccess = userAPI.register(userModel);

        if(isSuccess){
            return ResponseVO.success("注册成功");
        }else{
            return ResponseVO.serviceFail("注册失败");
        }
    }

    @RequestMapping(value = "check", method = RequestMethod.POST)
    public ResponseVO check(String username){
        if(username != null && username.trim().length()>0){
            if(userAPI.checkUsername(username)){
                return ResponseVO.success("用户名可以使用");
            }else{
                return ResponseVO.serviceFail("用户名已存在");
            }
        }else{
            return ResponseVO.serviceFail("用户名不能为空");
        }

    }

    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    public ResponseVO getUserInfo(){
        //获取登陆用户ID
        String userId = CurrentUser.getUserId();

        if(userId != null && userId.trim().length()>0){
            UserInfoModel userInfo = userAPI.getUserInfo(userId);
            if(userInfo != null){
                return ResponseVO.success(userInfo);
            }else{
                return ResponseVO.appFail("系统出现异常，请联系管理员");
            }

        }else{
            return ResponseVO.serviceFail("查询失败，用户尚未登陆");
        }

    }

    @RequestMapping(value = "updateUserInfo", method = RequestMethod.POST)
    public ResponseVO updateUserInfo(UserInfoModel userInfoModel) {
        //获取登陆用户ID
        String userId = CurrentUser.getUserId();

        if(userId != null && userId.trim().length()>0){
            if (!userId.equals(userInfoModel.getUuid())) {
                return ResponseVO.serviceFail("修改信息与登陆信息不符");
            }
            UserInfoModel userInfo = userAPI.updateUserInfo(userInfoModel);
            if(userInfo != null){
                return ResponseVO.success(userInfo);
            }else{
                return ResponseVO.appFail("用户信息修改失败");
            }

        }else{
            return ResponseVO.serviceFail("用户尚未登陆");
        }

    }
}
