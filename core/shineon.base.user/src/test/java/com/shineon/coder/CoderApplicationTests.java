package com.shineon.coder;

import com.shineon.coder.service.cache.UserCache;
import com.shineon.coder.service.convert.CommonData;
import com.shineon.coder.service.convert.CommonItem;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CoderApplicationTests {

    @Autowired
    UserCache cache;

    @Test
    public void contextLoads() throws Exception {

        CommonItem item = new CommonItem();

        List<CommonData> list = new ArrayList<>();

        CommonData data = new CommonData();

        data.setName("matao");

        data.setContent("11111111111111111111111111111111111111");

        list.add(data);

        item.setDatas(list);

       log.info("..................................." + cache.getSingleKey(item));
    }



    @Test
    public void loadCache() throws Exception {
        CommonItem item = new CommonItem();
        cache.setCache(item);

    }
}
