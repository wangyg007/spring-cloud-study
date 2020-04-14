package com.kone.serverdemohystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangyg
 * @time 2020/4/13 21:01
 * @note
 **/
//被调用的服务名
@FeignClient(value = "service-demo-client",fallback = HiHystrix.class)
public interface FeginInterfaceTest {

    //被调用路径
    @RequestMapping(value = "/hi/home",method = RequestMethod.GET)
    String getHome(@RequestParam String name);

}
