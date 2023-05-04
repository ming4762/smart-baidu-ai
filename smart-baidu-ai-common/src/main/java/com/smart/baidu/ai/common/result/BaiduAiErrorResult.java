package com.smart.baidu.ai.common.result;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhongming4762
 * 2023/5/4
 */
@Getter
@Setter
@ToString
public class BaiduAiErrorResult implements Serializable {

    @JsonAlias("log_id")
    private Long logId;

    @JsonAlias("error_msg")
    private String errorMsg;

    @JsonAlias("error_code")
    private Integer errorCode;
}
