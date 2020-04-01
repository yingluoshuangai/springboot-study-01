package xyz.xnmq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.xnmq.config.Config;
import xyz.xnmq.vo.UserVO;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Created xnmq
 * @Date 2020/3/16
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${test.config.name}")
    private String name;
    @Value("${test.config.password}")
    private String password;
    @Autowired
    private Config config;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping("firstConfInject")
    public void firstConfInject(){
        log.info("first conf inject : {}, {}", name, password);
    }

    @GetMapping("secondConfInject")
    public void secondConfInject(){
        log.info("second conf inject : {}, {}", config.getName(), config.getPassword());
    }

    @GetMapping("jackson")
    public UserVO jackson() throws IOException {
        UserVO userVO = UserVO.builder()
                .name("张三")
                .nickName("法外狂徒张三")
                .age(19)
                .address("北京")
                .registerTime(new Date())
                .build();
        String userJson = mapper.writeValueAsString(userVO);
        log.info("user json : {}", userJson);
        //return mapper.readValue(userJson, UserVO.class);
        return userVO;
    }
}
