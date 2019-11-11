package com.shineon.coder;

import com.shineon.coder.db.pojo.QueryItem;
import com.shineon.coder.kernel.constant.action.UserActionConstant;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.QueryItemCommonUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.ws.rs.core.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {
    @Autowired
    QueryItemCommonUtil commonUtil;


    @Autowired
    WebApplicationContext webApplication;

    private MockMvc mockMvc;
    @Before
    public void beforeMvc()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplication).build();
    }

    @Test
    public void get() throws Exception
    {
        QueryItem item = new QueryItem();

        item.setId("111");
        CommonItem commonItem = commonUtil.toCommon(item);

        MvcResult mvcResult = mockMvc.perform(
                post(UserActionConstant.ACTION_GET)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(commonItem.toJsonString()))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void edit() throws Exception
    {
        QueryItem item = new QueryItem();

        item.setId("111");
        item.setTitle("matao");
        CommonItem commonItem = commonUtil.toCommon(item);

        MvcResult mvcResult = mockMvc.perform(
                post(UserActionConstant.ACTION_EDIT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(commonItem.toJsonString()))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

}
