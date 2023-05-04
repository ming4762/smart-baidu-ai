package com.smart.baidu.ai.image.recognition.bean.result.logo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * ogo商标识别—删除 返回数据
 * @author zhongming4762
 * 2023/5/4
 */
@Getter
@Setter
public class LogoDeleteResult implements Serializable {

    @JsonAlias("log_id")
    private Long logId;

}
