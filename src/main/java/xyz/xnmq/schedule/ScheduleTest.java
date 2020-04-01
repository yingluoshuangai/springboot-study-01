package xyz.xnmq.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Created xnmq
 * @Date 2020/3/18
 * @Description
 */
@Slf4j
//@Component //需要将定时任务声明为bean
public class ScheduleTest {
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * 上一次开始执行时间点之后3000毫秒再去执行
     */
    @Scheduled(fixedRate = 3000)
    public void schedule01(){
        log.info("schedule01 -> {}", LocalDateTime.now().format(fmt));
    }

    /**
     * 上一次执行完毕时间点之后3000毫秒 再去执行
     */
    @Scheduled(fixedDelay = 3000)
    public void schedule02(){
        log.info("schedule02 -> {}", LocalDateTime.now().format(fmt));
    }

    /**
     * 第一次延迟2000毫秒执行，即应用启动之后，延迟2000毫秒第一次执行
     * 之后在上一次执行开始之后3000毫秒，再去执行
     */
    @Scheduled(initialDelay = 2000, fixedRate = 3000)
    public void schedule03(){
        log.info("schedule03 -> {}", LocalDateTime.now().format(fmt));
    }

    /**
     * 每隔3秒执行一次
     */
    @Scheduled(cron = "*/3 * * * * ?")
    public void schedule04(){
        log.info("shedule04 -> {}", LocalDateTime.now().format(fmt));
    }
}
