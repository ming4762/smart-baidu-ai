package com.smart.baidu.ai.common.exception;

/**
 * @author zhongming4762
 * 2023/5/4
 */
public class BaiduAiException extends RuntimeException {

    public BaiduAiException(String message) {
        super(message);
    }

    public BaiduAiException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaiduAiException(Throwable cause) {
        super(cause);
    }
}
