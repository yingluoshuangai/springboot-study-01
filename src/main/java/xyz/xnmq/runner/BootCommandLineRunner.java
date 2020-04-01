package xyz.xnmq.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Created xnmq
 * @Date 2020/3/19
 * @Description 开机启动服务
 */
@Slf4j
@Component
@Order(1)
public class BootCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("This is BootCommandLineRunner ...");

    }
}
