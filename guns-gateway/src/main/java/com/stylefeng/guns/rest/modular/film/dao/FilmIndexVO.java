package com.stylefeng.guns.rest.modular.film.dao;/**
 * Created by misdeadgirl on 2018/11/28.
 */

import com.stylefeng.guns.api.film.vo.BannersVO;
import com.stylefeng.guns.api.film.vo.FilmInfoVO;
import com.stylefeng.guns.api.film.vo.FilmVO;
import lombok.Data;

import java.util.List;

/**
 * @author
 * @create 2018-11-28 上午8:27
 **/
@Data
public class FilmIndexVO {

    private List<BannersVO> banners;
    private FilmVO hotFilms;
    private FilmVO soonFilms;
    private List<FilmInfoVO> boxRanking;
    private List<FilmInfoVO> expectRanking;
    private List<FilmInfoVO> top100;

}
