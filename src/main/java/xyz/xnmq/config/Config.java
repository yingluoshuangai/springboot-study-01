package xyz.xnmq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Created xnmq
 * @Date 2020/3/16
 * @Description
 */
@Data
@Component //声明这是一个Bean
@ConfigurationProperties(prefix = "test.config")
public class Config {
    private String name;
    private String password;
}
