package com.smart.baidu.ai.common.properties;

import lombok.*;

import java.io.Serializable;
import java.time.Duration;

/**
 * 百度AI 客户端参数配置
 * @author zhongming4762
 * 2023/5/4
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaiduAiAppProperties implements Serializable {

    private String appId;

    private String apiKey;

    private String secretKey;

    /**
     * 网络连接参数
     */
    @Builder.Default
    private Duration connectionTimeout = Duration.ofMillis(2000);
    @Builder.Default
    private Duration socketTimeout = Duration.ofMillis(60000);

    /**
     * 设置代理服务器地址, http和socket二选一，或者均不设置
     */
    private ProxyProperties httpProxy;
    private ProxyProperties socketProxy;


    @Getter
    @Setter
    @AllArgsConstructor
    public static class ProxyProperties implements Serializable {
        private String proxyHost;

        private Integer proxyPort;
    }

}
