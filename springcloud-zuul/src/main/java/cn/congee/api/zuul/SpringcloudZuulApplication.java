package cn.congee.api.zuul;

import com.spring4all.swagger.EnableSwagger2Doc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: yang
 * @Date: 2020-12-09 10:05
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient              //eurekaclient通用注册服务
@EnableZuulProxy                    //开启zuul服务
@EnableSwagger2Doc
public class SpringcloudZuulApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringcloudZuulApplication.class);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(SpringcloudZuulApplication.class,args);
        long end = System.currentTimeMillis();
        log.info("springcloud-zuul服务启动耗时为：" + (end - start) + "ms");
    }

}
