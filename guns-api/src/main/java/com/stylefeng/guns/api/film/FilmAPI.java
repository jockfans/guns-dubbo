package com.stylefeng.guns.api.film;/**
 * Created by misdeadgirl on 2018/11/28.
 */

import com.stylefeng.guns.api.film.vo.BannersVO;
import com.stylefeng.guns.api.film.vo.FilmInfoVO;
import com.stylefeng.guns.api.film.vo.FilmVO;

import java.util.List;

/**
 * @author
 * @create 2018-11-28 上午8:49
 **/
public interface FilmAPI {

    //1.获取banners
    List<BannersVO> getBanners();
    //2.获取热点影片hotfilm
    FilmVO getHotFilm(boolean sort,int num);
    //3.获取即将上映soonfilm(按受欢迎程度排序)
    FilmVO getSoonFilm(boolean sort,int num);
    //4.获取boxRanking
    List<FilmInfoVO> getBoxRanking();
    //5.获取期待排行exceptRanking
    List<FilmInfoVO> getExceptRanking();
    //6.获取top100
    List<FilmInfoVO> getTop();
}
