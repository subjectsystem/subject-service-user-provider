package com.miyako.subject.service.user.provider;

import com.alibaba.dubbo.config.annotation.Reference;
import com.miyako.subject.commons.domain.TbStudent;
import com.miyako.subject.commons.utils.MD5Util;
import com.miyako.subject.service.user.api.TbUserService;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * ClassName Test
 * Description //TODO
 * Author weila
 * Date 2019-08-08-0008 20:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SubjectServiceUserProviderApplication.class)
public class Test{

    private static Logger logger = LoggerFactory.getLogger(Test.class);

    @Reference
    private TbUserService tbUserService;

    @org.junit.Test
    public void insertStudent(){
        logger.info("test............嘎达嘎达嘎达是公开的萨芬撒旦发个.........");
        //Random random = new Random();
        //for (int i=3; i<2001; i++){
        //    TbStudent tbStudent = new TbStudent();
        //    tbStudent.setName("测试学生-"+i);
        //    tbStudent.setAge(+18+random.nextInt(4));
        //    tbStudent.setGender(random.nextInt(10)%2);
        //    tbStudent.setCollegeid(1);
        //    tbStudent.setPassword(MD5Util.MD5Encode("111111"));
        //    logger.info(tbUserService.insert(tbStudent).toString());
        //}
    }

    @org.junit.Test
    public void insertStudentById(){
        logger.info("test............嘎达嘎达嘎达是公开的萨芬撒旦发个.........");
        //TbStudent tbStudent = new TbStudent();
        //tbStudent.setName("测试学生11-");
        //tbStudent.setAge(18);
        //tbStudent.setGender(1);
        //tbStudent.setCollegeid(1);
        //tbStudent.setPassword(MD5Util.MD5Encode("111111"));
        ////logger.info("insert:"+tbUserService.insert(tbStudent).toString());
        //logger.info("insert selective:"+ tbUserService.insertById(tbStudent).toString());
        //logger.info("id:"+tbStudent.getId());
    }

}
