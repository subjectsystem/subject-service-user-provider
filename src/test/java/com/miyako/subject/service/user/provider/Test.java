package com.miyako.subject.service.user.provider;

import com.alibaba.dubbo.config.annotation.Reference;
import com.miyako.subject.commons.domain.TbStudent;
import com.miyako.subject.commons.mapper.TbStudentMapper;
import com.miyako.subject.commons.utils.MD5Util;
import com.miyako.subject.service.user.api.TbUserService;
import com.miyako.subject.service.user.provider.SubjectServiceUserProviderApplication;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

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
        Random random = new Random();
        for (int i=3; i<2001; i++){
            TbStudent tbStudent = new TbStudent();
            tbStudent.setName("测试学生-"+i);
            tbStudent.setAge(+18+random.nextInt(4));
            tbStudent.setGender(random.nextInt(10)%2);
            tbStudent.setCollegeid(1);
            tbStudent.setPassword(MD5Util.MD5Encode("111111"));
            logger.info(tbUserService.insert(tbStudent).toString());
        }
    }

}
