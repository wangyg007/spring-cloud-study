package com.kone.serverdemoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangyg
 * @time 2020/4/14 20:17
 * @note
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-DEMO-CLIENT/hi/home?name="+name,String.class);
    }


}
