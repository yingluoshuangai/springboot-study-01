package xyz.xnmq;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Created xnmq
 * @Date 2020/3/16
 * @Description springboot 启动类
 */
@SpringBootApplication
@EnableScheduling // 开启定时任务
@EnableAsync //开启异步支持
public class SpringBootStudyApplication {
    public static void main(String[] args) {
        //spingboot的3中启动方式

        // 1. 通过SpringApplication的run方法
        SpringApplication.run(SpringBootStudyApplication.class,args);

//        // 2. 通过Api方式启动,能够修改springboot启动时的一些配置
//        SpringApplication application = new SpringApplication(SpringBootStudyApplication.class);
//        //启动时 不显示spring标志
//        application.setBannerMode(Banner.Mode.OFF);
//        //不作为web应用启动 因为不作为web启动，没有开启端口，并等待，启动后，会自动结束
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.run(args);

//        // 3. SpringApplicationBuilder Fluent Api启动，实现链式调用
//        new SpringApplicationBuilder(SpringBootStudyApplication.class)
//                .bannerMode(Banner.Mode.OFF)
//                .run(args);
    }

}
