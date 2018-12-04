package com.stylefeng.guns.api.film.vo;/**
 * Created by misdeadgirl on 2018/11/28.
 */

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author
 * @create 2018-11-28 上午8:33
 **/
@Data
public class FilmVO implements Serializable{

    private String filmNum;
    private List<FilmInfoVO> filmInfo;
}
