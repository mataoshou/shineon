//package com.shineon.coder;
//
//import com.shineon.coder.db.dao.ShineonUserMapper;
//import com.sun.jersey.spi.container.WebApplication;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CoderApplicationTests {
//
//    @Autowired
//    ShineonUserMapper mapper;
//
//
//    @Test
//    public void contextLoads() {
//        System.out.println("................................" + mapper.selectByPrimaryKey(1).getUsername());
//
//    }
//
//    @Autowired
//    WebApplicationContext webApplication;
//
//
//    private MockMvc mockMvc;
//    @Before
//    public void beforeMvc()
//    {
//
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplication).build();
//
//
//    }
//
//
//    @Test
//    public void mvcTest() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/getUser?id=1"));
//    }
//
//}
