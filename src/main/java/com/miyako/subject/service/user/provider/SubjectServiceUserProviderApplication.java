package com.miyako.subject.service.user.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * ClassName SubjectServiceCourseProviderApplication
 * Description //TODO
 * Author weila
 * Date 2019-08-07-0007 11:22
 */
@EnableHystrix
@EnableHystrixDashboard
@ImportResource(value = {"classpath:provider.xml"})
@EnableDubboConfig
@EnableTransactionManagement
@MapperScan(basePackages = "com.miyako.subject.commons.mapper")
@SpringBootApplication(scanBasePackages = "com.miyako.subject")
public class SubjectServiceUserProviderApplication{
    public static void main(String[] args) {
        SpringApplication.run(SubjectServiceUserProviderApplication.class, args);
        Main.main(args);
    }
}
