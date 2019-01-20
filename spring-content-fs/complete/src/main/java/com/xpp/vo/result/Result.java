package com.xpp.vo.result;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengyuxiang
 * @date 2019/1/16
 */
public class Result {
    private Integer code;
    private List<ResultBean> result;


    public Result() {
        if(this.getResult() == null){
            this.setResult(new ArrayList<ResultBean>());
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public void addResultBean(ResultBean resultBean){
        this.getResult().add(resultBean);
    }
}
