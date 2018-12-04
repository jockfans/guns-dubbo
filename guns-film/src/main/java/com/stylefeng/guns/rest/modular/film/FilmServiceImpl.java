package com.stylefeng.guns.rest.modular.film;/**
 * Created by misdeadgirl on 2018/11/29.
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.film.FilmAPI;
import com.stylefeng.guns.api.film.vo.BannersVO;
import com.stylefeng.guns.api.film.vo.FilmInfoVO;
import com.stylefeng.guns.api.film.vo.FilmVO;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.rest.common.persistence.dao.MoocBannerTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MoocFilmTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocBannerT;
import com.stylefeng.guns.rest.common.persistence.model.MoocFilmT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @create 2018-11-29 下午2:27
 **/
@Component
@Service(interfaceClass = FilmAPI.class)
public class FilmServiceImpl implements FilmAPI {

    //自动注入使用TMapper对象操作查询,返回为T对象
    @Autowired
    private MoocBannerTMapper moocBannerTMapper;

    @Autowired
    private MoocFilmTMapper moocFilmTMapper;

    @Override
    public List<BannersVO> getBanners() {

        List<MoocBannerT> bannersVOs = moocBannerTMapper.selectList(null);
            List<BannersVO> listBanners = new ArrayList<>();
            for (MoocBannerT moocBanner: bannersVOs) {
                BannersVO bannerVO = new BannersVO();
                bannerVO.setBannerId(moocBanner.getUuid().toString());
                bannerVO.setBannerAddress(moocBanner.getBannerAddress());
                bannerVO.setBannerUrl(moocBanner.getBannerUrl());
                listBanners.add(bannerVO);
            }
            return listBanners;
    }

    //影片对象由DAO转换为前端VO
    private List<FilmInfoVO> getFilmInfos(List<MoocFilmT> moocFilmTs){
        List<FilmInfoVO> filmInfoVOs = new ArrayList<>();
        for (MoocFilmT moocFilmT: moocFilmTs) {
            FilmInfoVO filmInfoVO = new FilmInfoVO();
            filmInfoVO.setShowTime(DateUtil.getDay(moocFilmT.getFilmTime()));
            filmInfoVO.setScore(moocFilmT.getFilmScore());
            filmInfoVO.setImgAddress(moocFilmT.getImgAddress());
            filmInfoVO.setFilmType(moocFilmT.getFilmType());
            filmInfoVO.setFilmName(moocFilmT.getFilmName());
            filmInfoVO.setFilmId(moocFilmT.getUuid()+"");
            filmInfoVO.setExpectNum(moocFilmT.getFilmPresalenum());//预售作为影片期待
            filmInfoVO.setBoxNum(moocFilmT.getFilmBoxOffice());
            filmInfoVO.setFilmScore(moocFilmT.getFilmScore());

            filmInfoVOs.add(filmInfoVO);
        }
        return filmInfoVOs;
    }

    @Override
    public FilmVO getHotFilm(boolean islimit, int num) {
        FilmVO filmVO = new FilmVO();
        List<FilmInfoVO> filmInfoVOs = new ArrayList<>();

        //通过EntityWraper筛选热映条件
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","1");//film_status字段的值1为热映电影
        if(islimit){
            Page<MoocFilmT> page = new Page<>(1,num);//当前页,查询条数
            List<MoocFilmT> moocFilmTs = moocFilmTMapper.selectPage(page,entityWrapper);

            filmInfoVOs = getFilmInfos(moocFilmTs);
            filmVO.setFilmNum(filmInfoVOs.size()+"");
            filmVO.setFilmInfo(filmInfoVOs);
        }else{

        }
        return filmVO;
    }

    @Override
    public FilmVO getSoonFilm(boolean islimit, int num) {

        FilmVO filmVO = new FilmVO();
        List<FilmInfoVO> filmInfoVOs = new ArrayList<>();

        //通过EntityWraper筛选热映条件
        EntityWrapper<MoocFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","2");//film_status字段的值2为即将上映电影
        if(islimit){
            Page<MoocFilmT> page = new Page<>(1,num);//当前页,查询条数
            List<MoocFilmT> moocFilmTs = moocFilmTMapper.selectPage(page,entityWrapper);

            filmInfoVOs = getFilmInfos(moocFilmTs);
            filmVO.setFilmNum(filmInfoVOs.size()+"");
            filmVO.setFilmInfo(filmInfoVOs);
        }else{

        }
        return filmVO;
    }

    @Override
    public List<FilmInfoVO> getBoxRanking() {
        return null;
    }

    @Override
    public List<FilmInfoVO> getExceptRanking() {
        return null;
    }

    @Override
    public List<FilmInfoVO> getTop() {
        return null;
    }
}
