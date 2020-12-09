package cn.congee.api.bootadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: yang
 * @Date: 2020-12-09 9:58
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient              //eurekaclient通用注册服务
@EnableAdminServer                  //监控中心服务端
public class SpringcloudBootadminApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringcloudBootadminApplication.class);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(SpringcloudBootadminApplication.class,args);
        long end = System.currentTimeMillis();
        log.info("springcloud-bootadmin服务启动耗时为：" + (end - start) + "ms");
    }

}
