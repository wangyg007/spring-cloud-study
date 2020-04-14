package com.kone.serverdemohystrix;

import org.springframework.stereotype.Component;

/**
 * @author wangyg
 * @time 2020/4/14 20:30
 * @note
 **/
@Component
public class HiHystrix implements FeginInterfaceTest{

    @Override
    public String getHome(String name) {
        return "sorry "+name+" error occur!!!";
    }
}
