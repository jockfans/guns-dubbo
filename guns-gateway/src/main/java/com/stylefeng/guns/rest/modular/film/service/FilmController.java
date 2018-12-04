package com.stylefeng.guns.rest.modular.film.service;/**
 * Created by misdeadgirl on 2018/11/27.
 */

import com.stylefeng.guns.api.film.vo.BannersVO;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @create 2018-11-27 下午10:26
 **/

@RestController
@RequestMapping("/film/")
public class FilmController {

    //在gateway想前端提供接口,向后台组合交易,访问多个接口组合数据
    public ResponseVO getIndex(){

        //1.获取banners
        //2.获取热点影片hotfilm
        //3.获取即将上映soonfilm
        //4.获取boxRanking票房
        //5.获取期待排行exceptRanking期待
        //6.获取top100
        return null;
    }
}
