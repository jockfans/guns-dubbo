package com.stylefeng.guns.api.film.vo;/**
 * Created by misdeadgirl on 2018/11/28.
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 * @create 2018-11-28 上午8:28
 **/
@Data
public class BannersVO implements Serializable{

    private String bannerId;
    private String bannerAddress;
    private String bannerUrl;
}
