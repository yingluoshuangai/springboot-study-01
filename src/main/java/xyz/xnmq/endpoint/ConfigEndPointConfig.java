package xyz.xnmq.endpoint;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Created xnmq
 * @Date 2020/3/20
 * @Description
 */
@Configuration
public class ConfigEndPointConfig {
    @Bean
    @ConditionalOnMissingBean // 当bean缺少时，才会注入bean
    @ConditionalOnEnabledEndpoint // 只有当开启自定义端点时，才注入bean
    public ConfigEndPoint asyncPoolEndPoint(){
        return new ConfigEndPoint();
    }
}
