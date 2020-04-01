package xyz.xnmq.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @Created xnmq
 * @Date 2020/3/19
 * @Description Jackson 的配置
 */
@Configuration
public class JacksonConfig {

    @Bean //将ObjectMapper作为bean，注入spring容器，在其他地方，通过@Autowired来注入，并使用
    public ObjectMapper getObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        //设置序列化时， 忽略值为null的属性
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //设置序列化时，时间的格式
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return mapper;
    }
}
