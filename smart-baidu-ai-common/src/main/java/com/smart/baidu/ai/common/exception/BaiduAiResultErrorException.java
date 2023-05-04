package com.smart.baidu.ai.common.exception;

import com.smart.baidu.ai.common.result.BaiduAiErrorResult;
import com.smart.baidu.ai.common.utils.JsonUtils;
import lombok.Getter;

/**
 * 百度AI结果异常
 * @author zhongming4762
 * 2023/5/4
 */
public class BaiduAiResultErrorException extends RuntimeException {

    @Getter
    private final BaiduAiErrorResult errorResult;

    public BaiduAiResultErrorException(BaiduAiErrorResult errorResult) {
        super(String.format("百度AI调用失败，错误信息：%s，原始报文：%s", errorResult.getErrorMsg(), JsonUtils.toJsonString(errorResult)));
        this.errorResult = errorResult;
    }
}
