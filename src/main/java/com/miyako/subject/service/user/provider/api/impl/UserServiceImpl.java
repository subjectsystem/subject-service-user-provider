package com.miyako.subject.service.user.provider.api.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miyako.subject.commons.domain.TbStudent;
import com.miyako.subject.commons.mapper.TbStudentMapper;
import com.miyako.subject.dubbo.aop.MethodLog;
import com.miyako.subject.service.redis.api.RedisService;
import com.miyako.subject.service.redis.key.StudentKey;
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

    @Reference
    private RedisService redisService;

    @Override
    @MethodLog(value = "UserServiceImpl", operationType = "数据库访问", operationName = "selectAll")
    public List<TbStudent> selectAll(){
        return tbStudentMapper.selectAll();
    }

    @Override
    @MethodLog(value = "UserServiceImpl", operationType = "数据库访问", operationName = "selectById",operationArgs = "用户id")
    public TbStudent selectById(Integer id){
        return tbStudentMapper.selectByPrimaryKey(id);
    }

    @Override
    @MethodLog(value = "UserServiceImpl", operationType = "数据库访问", operationName = "selectOne", operationArgs = "用户")
    public TbStudent selectOne(TbStudent tbStudent){
        return tbStudentMapper.selectOne(tbStudent);
    }

    @Override
    @MethodLog(value = "UserServiceImpl", operationType = "数据库访问", operationName = "selectAll")
    public Integer insert(TbStudent tbStudent){
        logger.info("===>:UserServiceImpl insert...");
        return tbStudentMapper.insert(tbStudent);
    }

    @Override
    @MethodLog(value = "UserServiceImpl", operationType = "数据库访问", operationName = "page", operationArgs = "分页信息")
    public PageInfo<TbStudent> page(int pageNum, int pageSize){
        Example example = new Example(TbStudent.class);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TbStudent> pageInfo = new PageInfo<>(tbStudentMapper.selectByExample(example));
        return pageInfo;
    }

    @Override
    @MethodLog(value = "UserServiceImpl", operationType = "redis访问", operationName = "getByToken", operationArgs = "token")
    public TbStudent getByToken(String token){
        if(StringUtils.isEmpty(token)) {
            return null;
        }
        TbStudent student = redisService.get(StudentKey.token, token, TbStudent.class);
        // 再次请求时候，延长有效期
        // 重新设置缓存里面的值，使用之前cookie里面的token
        //if(user!=null) {
        //    addCookie(user,token,response);
        //}
        logger.info(StudentKey.token.getPrefix() + "->" + token +":"+ student.getName());
        return student;
    }

}
