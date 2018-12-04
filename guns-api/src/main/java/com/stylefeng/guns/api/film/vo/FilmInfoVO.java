package com.stylefeng.guns.api.film.vo;/**
 * Created by misdeadgirl on 2018/11/28.
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 * @create 2018-11-28 上午8:34
 **/
@Data
public class FilmInfoVO implements Serializable {

    private String filmId;
    private int filmType;
    private String imgAddress;
    private String filmName;
    private String filmScore;
    private int expectNum;
    private String showTime;
    private int boxNum;
    private String score;
}
