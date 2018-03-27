package com.resale.demo;


import com.resale.background.service.MerchantService;
import com.resale.background.util.PageModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {


    @Autowired
    private MerchantService merchantService;

    @Test
    public void getMerchantList(){
        Map<String, Object> paramsCondition = new HashMap<>();
        paramsCondition.put("pageNo",0);
        paramsCondition.put("pageSize",5);
        PageModel merchantList = merchantService.getMerchantList(paramsCondition);
    }
}
