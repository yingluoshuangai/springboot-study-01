package xyz.xnmq.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import xyz.xnmq.config.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created xnmq
 * @Date 2020/3/20
 * @Description Actuator 自定义端点
 */
@Endpoint(id = "configEndPoint") //自定义端点的路径
public class ConfigEndPoint {
    @Autowired()
    private Config config;

    /**
     * 用来返回信息
     * 返回信息与修改信息都是同一个路径，/actuator/configEndPoint
     * 通过请求方式区分
     * get是返回信息
     * post是修改信息
     * @return
     */
    @ReadOperation
    public Map<String, Object> getInfo(){
        Map<String, Object> info = new HashMap<>();
        info.put("name", config.getName());
        info.put("password", config.getPassword());
        return info;
    }

    /**
     * 用来修改信息
     * @param name
     * @param password
     */
    @WriteOperation
    public void setInfo(String name, String password){
        config.setName(name);
        config.setPassword(password);
    }
}
