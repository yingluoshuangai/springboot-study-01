package xyz.xnmq.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Created xnmq
 * @Date 2020/3/19
 * @Description 异步线程池配置
 */
@Slf4j
@Configuration
public class AsyncPoolConfig implements AsyncConfigurer {

    //自定义异步线程池
    @Bean //需要当成bean 注入进来
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(10); // 线程池核心线程数10，默认为1
        executor.setMaxPoolSize(20); // 线程池最大线程数20
        executor.setQueueCapacity(20); // 缓存队列的大小
        executor.setKeepAliveSeconds(60); // 超出核心线程数的空闲线程 存活时间
        executor.setThreadNamePrefix("async_"); // 线程名前缀

        executor.setWaitForTasksToCompleteOnShutdown(true); //等待所有线程执行完毕，才去关闭线程池， 默认false
        executor.setAwaitTerminationSeconds(60); //

        //拒绝策略
        executor.setRejectedExecutionHandler(
                new ThreadPoolExecutor.CallerRunsPolicy());

        //线程池初始化
        executor.initialize();
        return executor;
    }

    /**
     * 定义异步任务异常处理类
     * 异步线程池出现异常，该方法会捕获该异常，但是只针对没有返回值的线程，有返回值的线程可以将异常返回，不需要该类处理
     * @return
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }

    class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler{
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            //这里只将错误信息打印出来
            log.info("AsyncError: {}, Method: {}, Param: {}",
                    throwable.getMessage(),
                    method.getName(),
                    JSON.toJSONString(objects));
            throwable.printStackTrace();
            // TODO 发送邮件或者短信

        }
    }
}
