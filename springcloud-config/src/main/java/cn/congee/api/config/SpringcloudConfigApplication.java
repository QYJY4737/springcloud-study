package cn.congee.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author: yang
 * @Date: 2020-12-09 10:24
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient                  //eurekaclient通用注册服务
@EnableConfigServer                     //配置中心服务端
public class SpringcloudConfigApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringcloudConfigApplication.class);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(SpringcloudConfigApplication.class,args);
        long end = System.currentTimeMillis();
        log.info("springcloud-config服务启动耗时为：" + (end - start) + "ms");
    }

}
