package com.miyako.subject.service.user.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.miyako.subject.commons.domain.TbStudent;
import com.miyako.subject.commons.mapper.TbStudentMapper;
import com.miyako.subject.service.user.api.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName CourseServiceImpl
 * Description //TODO
 * Author weila
 * Date 2019-08-07-0007 14:08
 */
@Service
//@Transactional(readOnly = true)
@Component
public class UserServiceImpl implements TbUserService{

    @Autowired
    private TbStudentMapper tbStudentMapper;

    @Override
    public List<TbStudent> selectAll(){
        System.out.println("dubbo...");
        return tbStudentMapper.selectAll();
    }
}
