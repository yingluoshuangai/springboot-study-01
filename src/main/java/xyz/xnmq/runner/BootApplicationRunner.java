package xyz.xnmq.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Created xnmq
 * @Date 2020/3/19
 * @Description 开机启动任务
 */
@Slf4j
@Component //声明是Bean，并注入
@Order(2)
public class BootApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(" This is BootApplicationRunner ...");
    }
}
