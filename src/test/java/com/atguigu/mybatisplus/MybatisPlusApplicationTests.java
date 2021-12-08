package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import java.util.*;
import java.util.logging.SimpleFormatter;

@SpringBootTest
//@MapperScan("com.atguigu.mybatisplus.mapper")
//@ComponentScan("com.atguigu.mybatisplus.handler")
class MybatisPlusApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testSelectList() {
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void insertTest() {
        System.out.println(("----- insert method test ------"));
        User user = new User();
        user.setAge(111);
        user.setName("market");
        user.setEmail("123456789@qq.com");
        //user.setCreateTime(new Date());
        userMapper.insert(user);
    }

    //修改操作
    @Test
    public void updateTest(){
        User user = new User();
        user.setId(9L);
        user.setAge(20);
        int number = userMapper.updateById(user);
        System.out.println(number);

    }

    //乐观锁测试
    @Test
    public void OptimisticTest(){
        User user = userMapper.selectById(7L);
        //user.setId(9L);
        user.setAge(120);
        int number = userMapper.updateById(user);
        System.out.println(number);
    }

    //乐观锁测试
    @Test
    public void Optimistic1Test(){
        User user = userMapper.selectById(10L);
        //user.setId(9L);
        user.setAge(10);
        user.setVersion(user.getVersion()-1);
        int number = userMapper.updateById(user);
        System.out.println(number);
    }

    //多id查询
    @Test
    public void selectbyids(){
        List<User> Users = userMapper.selectBatchIds(Arrays.asList(1,2,3,4));
        System.out.println(Users);
    }

    //多条件查询
    @Test
    public void selectbymap(){
        List<User> Users = userMapper.selectBatchIds(Arrays.asList(1,2,3,4));
        HashMap<String,Object> maps = new HashMap<String,Object>();
        maps.put("name","Jone");
        maps.put("age",120);
        List<User> user = userMapper.selectByMap(maps);
        System.out.println(user);
    }

    //selectPage分页查询
    @Test
    public void testSelectPage() {

        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page, null);

        page.getRecords().forEach(System.out::println);
        for (User user:
        page.getRecords()) {
            System.out.println("user:" + user);
        };
        System.out.println("page.getCurrent:" + page.getCurrent());
        System.out.println("page.getPages:" + page.getPages());
        System.out.println("page.getSize:" + page.getSize());
        System.out.println("page.getTotal:" + page.getTotal());
        System.out.println("page.hasNext:" + page.hasNext());
        System.out.println("page.hasPrevious:" + page.hasPrevious());
    }

    @Test
    public void testSelectMapsPage() {

        Page<User> page = new Page<>(1, 5);

        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);

        //注意：此行必须使用 mapIPage 获取记录列表，否则会有数据类型转换错误
        mapIPage.getRecords().forEach(System.out::println);
        System.out.println(mapIPage.getRecords());
        for (Map map:
             mapIPage.getRecords()) {
            System.out.println("map " + map);
        }
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    //根据id进行删除
    @Test
    public void deletebyid(){
        int result = userMapper.deleteById(9L);
        System.out.println(result);
    }

    //根据id批量删除
    @Test
    public void deleteBatchIdsTest(){
        int result = userMapper.deleteBatchIds(Arrays.asList(13,12,11));
        System.out.println(result);
    }

    //简单条件查询
    @Test
    public void deleteByMapTest(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("age",120);
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    //按照必要条件查询
    @Test
    public void selectOne(){
        List<User> user = userMapper.selectBatchIds(Arrays.asList(1,2,3,4,5));
        System.out.println(user);
        System.out.println("-------------------------");
        user.forEach(System.out::println);
    }

    //按照必要条件查询
    @Test
    public void treesettest(){
        TreeSet set = new TreeSet();

        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));

        //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：
//        set.add(new User("Tom",12));
//        set.add(new User("Jerry",32));
//        set.add(new User("Jim",2));
//        set.add(new User("Mike",65));
//        set.add(new User("Jack",33));
//        set.add(new User("Jack",56));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


    @Test
    public void treeettest(){
        System.out.println(Integer.compare(2,1));

        String phone="15290009226";
        String reg_tel = "^[1][3,4,5,7,8][0-9]{9}";
        System.out.println(phone.matches(reg_tel));  //true
        System.out.println(reg_tel.matches(phone)); //false

        Integer integer = 2;
        Integer int2 = 2;
        System.out.println(integer==2);             //true
        System.out.println(int2 == integer);        //true
        String str = "";
        str.equals("1");
        int2.equals(2);
        //今日目标，整理MySQL数据库
        //
    }
    //周四整理：Java基础
    //周五整理：Java基础
    //周六晚整理：mybatis
    //spring\springmvc\redis\mq
    @Test
    public void trrttest(){
        System.out.println(Integer.compare(2,1));
        //、
        System.out.println("        System.out.println(\"\");\n");
        String str = "132";
        System.out.println("132".equals(str));
        System.out.println(Objects.equals(str,"132"));
        int i = 0;
        int a = 5;
        //i = i+++5;
        System.out.println(++i+a);
    }


}
