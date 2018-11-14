package com.stylefeng.guns.rest.modular.user;/**
 * Created by misdeadgirl on 2018/11/8.
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.api.user.UserInfoModel;
import com.stylefeng.guns.api.user.UserModel;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.persistence.dao.MoocUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocUserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author
 * @create 2018-11-08 上午10:23
 **/
@Component
@Service(interfaceClass = UserAPI.class)
public class UserServiceImpl implements UserAPI{
    //微服务中Service一般指对外暴露服务的

    //注入MoocUserTMapper,需要引入maven依赖
    @Autowired
    private MoocUserTMapper moocUserTMapper;

    @Override
    public int userLogin(String username, String password) {
        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUserName(username);
        MoocUserT result = moocUserTMapper.selectOne(moocUserT);
        if(result!=null && result.getUuid()>0){
            String md5Password = MD5Util.encrypt(password);
            if(result.getUserPwd().equals(md5Password)){
                return result.getUuid();
            }
        }

        return 0;
    }

    @Override
    public boolean register(UserModel userModel) {

        MoocUserT moocUserT = new MoocUserT();
        moocUserT.setUserName(userModel.getUsername());
        moocUserT.setUserPwd(MD5Util.encrypt(userModel.getPassword()));
        moocUserT.setUserPhone(userModel.getPhone());
        moocUserT.setEmail(userModel.getEmail());
        moocUserT.setAddress(userModel.getAddress());
        Integer insert = moocUserTMapper.insert(moocUserT);
        if(insert > 0){
            return true;
        } else {
            return false;
        }


    }

    @Override
    public boolean checkUsername(String username) {
        EntityWrapper<MoocUserT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name",username);//直接用名称与数据库字段内的值匹配
        Integer result = moocUserTMapper.selectCount(entityWrapper);//查询出的数量
        if(result!=null && result>0){//如果大于0则说明用户名称已存在
            return false;
        }else {
            return true;
        }
    }

    @Override
    public UserInfoModel getUserInfo(String uuid) {
        return null;
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        return null;
    }
}
