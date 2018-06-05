package com.example.demo;

import com.ying.background.Application;
import com.ying.background.mapper.BookInfoMapper;
import com.ying.background.mapper.CustomerMapper;
import com.ying.background.services.customer.ICustomerService;
import com.ying.background.services.test.ITestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class DemoApplicationTests {

//    @Autowired
//    private ITestService testService;
//
//    @Autowired
//    private CustomerMapper customerMapper;
//
//    @Autowired
//    private ICustomerService customerService;
//
    @Autowired
    private BookInfoMapper bookInfoMapper;
//
//	@Test
//	public void test() {
//        System.out.println(testService.getAll().size());
//    }
//
//    @Test
//    public void test2(){
////        System.out.println(customerMapper.toLogin("2018","zqx2018") == null);
//
//        System.out.println(customerService.login("2018", "zqx2018", null, null).getToken());
//    }
//
    @Test
    public void test3(){
        System.out.println(bookInfoMapper.selectByPrimaryKey(1L));
    }

}
