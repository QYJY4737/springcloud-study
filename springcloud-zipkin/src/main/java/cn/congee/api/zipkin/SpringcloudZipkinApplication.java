package cn.congee.api.zipkin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.internal.EnableZipkinServer;

/**
 * @Author: yang
 * @Date: 2020-12-09 10:31
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient                      //eurekaclient通用注册服务
@EnableZipkinServer                         //启用链路追踪服务端
public class SpringcloudZipkinApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringcloudZipkinApplication.class);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(SpringcloudZipkinApplication.class,args);
        long end = System.currentTimeMillis();
        log.info("springcloud-zipkin服务启动耗时为：" + (end - start) + "ms");
    }

}
