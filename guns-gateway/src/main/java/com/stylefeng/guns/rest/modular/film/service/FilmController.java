package com.stylefeng.guns.rest.modular.film.service;/**
 * Created by misdeadgirl on 2018/11/27.
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.film.FilmAPI;
import com.stylefeng.guns.rest.modular.film.dao.FilmIndexVO;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @create 2018-11-27 下午10:26
 **/

@RestController
@RequestMapping("/film/")
public class FilmController {

    //注入接口
    @Reference(interfaceClass = FilmAPI.class)
    private FilmAPI filmAPI;

    //在gateway想前端提供接口,向后台组合交易,访问多个接口组合数据
    @RequestMapping(value = "getIndex",method = RequestMethod.GET)
    public ResponseVO getIndex(){

        FilmIndexVO filmIndexVO = new FilmIndexVO();
        //1.获取banners
        filmIndexVO.setBanners(filmAPI.getBanners());
        //2.获取热点影片hotfilm
        filmIndexVO.setHotFilms(filmAPI.getHotFilm(true,8));
        //3.获取即将上映soonfilm
        filmIndexVO.setSoonFilms(filmAPI.getSoonFilm(true,8));
        //4.获取boxRanking票房
        filmIndexVO.setBoxRanking(filmAPI.getBoxRanking());
        //5.获取期待排行exceptRanking期待
        filmIndexVO.setExpectRanking(filmAPI.getExceptRanking());
        //6.获取top100
        filmIndexVO.setTop100(filmAPI.getTop());
        return ResponseVO.success(filmIndexVO);
    }
}
