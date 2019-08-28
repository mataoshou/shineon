//package com.mg.coder.controller;
//
//import com.mg.coder.convert.CommonItem;
//import com.mg.coder.convert.CommonItemUtils;
//import com.mg.coder.convert.util.ShineonUserCommonUtil;
//import com.mg.coder.nodb.dao.GeneralDao;
//import com.shineon.coder.db.dao.ShineonUserMapper;
//import com.shineon.coder.db.pojo.ShineonUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
//@RestController
//public class UserController {
//
//    @Resource
//    RedisTemplate redisTemplate;
//
//    @Autowired
//    ShineonUserMapper shineonUserMapper;
//
//    @Autowired
//    GeneralDao generalDao;
//
//    @Autowired
//    ShineonUserCommonUtil commonUtil;
//
//    @Autowired
//    CommonItemUtils commonItemUtils;
//
//    @RequestMapping("/getUser")
//    public CommonItem get(@RequestParam("id")int id)
//    {
//
//        System.out.println(".....................begin" +id);
//        ShineonUser user = shineonUserMapper.selectByPrimaryKey(id);
//        System.out.println(user.getUsername());
//
//        return commonItemUtils.success(commonUtil.shineonUserToCommon(user));
//
////        ShineonUser shineonUser = new ShineonUser();
////        shineonUser.setUsername("2");
////        shineonUser.setPassword("2");
////
////        shineonUserMapper.insertSelective(shineonUser);
////
////        redisTemplate.opsForValue().set("user", JSON.toJSONString(user) );
////
////        Set<String> set =  redisTemplate.keys("u*");
////
////        Iterator<String> iter = set.iterator();
////
////        while (iter.hasNext())
////        {
////            System.out.println(".............."+iter.next());
////        }
////
////        System.out.println( redisTemplate.opsForValue().get("user").toString());
////
////
////        GeneralItem item = new GeneralItem();
////        item.setContent("111111111111111" +"aaaaa22222");
////
////        item.setType(100);
////        generalDao.insert(item);
////
////
////        System.out.println(item.getId());
////
////        List<GeneralItem> list = generalDao.findall(GeneralItem.class);
////
////        for(GeneralItem item1: list)
////        {
////            System.out.println("........"+item1.getId() +"....." +item1.getType() +"...." +item1.getContent());
////        }
////
////
////
////        List<GeneralItem> list1 = generalDao.findall("2222");
////
////        for(GeneralItem item1: list1)
////        {
////            System.out.println("111111111........"+item1.getId() +"....." +item1.getType()+"...." +item1.getContent());
////        }
////
////
////        List<GeneralItem> list2 = generalDao.findall(0);
////
////
////        for(GeneralItem item1: list2)
////        {
////            System.out.println("2222222........"+item1.getId() +"....." +item1.getType()+"...." +item1.getContent());
////        }
//
//
//
////        return null;
//    }
//
//}
