package com.stylefeng.guns.api.user;/**
 * Created by misdeadgirl on 2018/11/12.
 */

import java.io.Serializable;

/**
 * @author
 * @create 2018-11-12 下午8:59
 **/
public class UserModel implements Serializable {

    //实现序列化接口,用于项目间传输
    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
