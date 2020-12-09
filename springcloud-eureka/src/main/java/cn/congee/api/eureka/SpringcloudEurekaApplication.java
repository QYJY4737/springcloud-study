package cn.congee.api.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: yang
 * @Date: 2020-12-09 9:49
 */
@Slf4j
@SpringBootApplication
@EnableEurekaServer             //eurekaserver服务端
public class SpringcloudEurekaApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringcloudEurekaApplication.class);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(SpringcloudEurekaApplication.class,args);
        long end = System.currentTimeMillis();
        log.info("springcloud-eureka服务启动耗时为：" + (end - start) + "ms");
    }
}
