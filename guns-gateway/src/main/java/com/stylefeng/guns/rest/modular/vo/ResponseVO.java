package com.stylefeng.guns.rest.modular.vo;/**
 * Created by misdeadgirl on 2018/11/13.
 */

/**
 * @author
 * @create 2018-11-13 下午2:56
 **/
public class ResponseVO<M> {

    //返回状态:0,成功 1,业务失败 999,系统异常
    private int status;
    //返回信息
    private String msg;
    //返回实体数据
    private M data;

    //私有构造,不允许在外部创建实体
    private ResponseVO(){}

    public static <M> ResponseVO success(M m){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(0);
        responseVO.setData(m);
        return responseVO;
    }

    public static ResponseVO serviceFail(String msg){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(1);
        responseVO.setMsg(msg);
        return responseVO;
    }

    public static ResponseVO appFail(String msg){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setStatus(999);
        responseVO.setMsg(msg);
        return responseVO;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public M getData() {
        return data;
    }

    public void setData(M data) {
        this.data = data;
    }
}
