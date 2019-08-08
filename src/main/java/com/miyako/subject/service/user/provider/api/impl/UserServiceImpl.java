package com.miyako.subject.service.user.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miyako.subject.commons.domain.TbStudent;
import com.miyako.subject.commons.mapper.TbStudentMapper;
import com.miyako.subject.commons.utils.MD5Util;
import com.miyako.subject.service.user.api.TbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Random;

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

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private TbStudentMapper tbStudentMapper;

    @Override
    public List<TbStudent> selectAll(){
        logger.info("===>:UserServiceImpl select all...");
        return tbStudentMapper.selectAll();
    }

    @Override
    public TbStudent selectById(Integer id){
        logger.info("===>:UserServiceImpl select by Id...");
        return tbStudentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer insert(TbStudent tbStudent){
        logger.info("===>:UserServiceImpl insert...");
        return tbStudentMapper.insert(tbStudent);
    }

    @Override
    public PageInfo<TbStudent> page(int pageNum, int pageSize){
        Example example = new Example(TbStudent.class);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TbStudent> pageInfo = new PageInfo<>(tbStudentMapper.selectByExample(example));
        return pageInfo;
    }

}
