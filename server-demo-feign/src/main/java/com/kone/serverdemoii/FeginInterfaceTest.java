package com.kone.serverdemoii;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangyg
 * @time 2020/4/13 21:01
 * @note
 **/
@FeignClient(value = "service-demo-i")
public interface FeginInterfaceTest {

    @RequestMapping(value = "/hi/home",method = RequestMethod.GET)
    String getHome(@RequestParam String name);

}
