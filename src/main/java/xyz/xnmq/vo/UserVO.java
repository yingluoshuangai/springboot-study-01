package xyz.xnmq.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Created xnmq
 * @Date 2020/3/19
 * @Description
 */
@Data
@NoArgsConstructor // 没有无参构造器
@AllArgsConstructor // 一个全部参数的构造器
@Builder
@JsonIgnoreProperties({"address", "age"})//忽略address参数
public class UserVO {
    private String name;
    private String nickName;
    private int age;
    private String address;
    private String sex;
    @JsonProperty("rt") // 参数别名为rt
    private Date registerTime;

}
