package com.smart.baidu.ai.common.service.impl;

import com.smart.baidu.ai.common.exception.BaiduAiException;
import com.smart.baidu.ai.common.properties.BaiduAiAppProperties;
import com.smart.baidu.ai.common.service.SmartBaiduAiService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * @author zhongming4762
 * 2023/5/4
 */
public class BaseSmartBaiduAiServiceImpl<T> implements SmartBaiduAiService<T> {

    private Map<String, ClientCache<T>> clientCacheMap = new ConcurrentHashMap<>();

    private String defaultAppId;

    @AllArgsConstructor
    @Setter
    @Getter
    @NoArgsConstructor
    private static class ClientCache<T> {
        private BaiduAiAppProperties properties;

        private T client;
    }

    /**
     * 验证APP参数
     *
     * @param properties 参数
     * @return 验证结果
     */
    @Override
    public boolean validateAppProperties(BaiduAiAppProperties properties) {
        if (StringUtils.isBlank(properties.getAppId())) {
            throw new BaiduAiException("appid 不能为空");
        }
        if (StringUtils.isBlank(properties.getApiKey())) {
            throw new BaiduAiException("apiKey不能为空");
        }
        if (StringUtils.isBlank(properties.getSecretKey())) {
            throw new BaiduAiException("secretKey不能为空");
        }
        if (properties.getConnectionTimeout() == null) {
            throw new BaiduAiException("connectionTimeout不能为空");
        }
        if (properties.getSocketTimeout() == null) {
            throw new BaiduAiException("socketTimeout不能为空");
        }
        if (properties.getHttpProxy() != null && properties.getSocketProxy() != null) {
            throw new BaiduAiException("http和socket代理只能二选一，或者均不设置");
        }
        return true;
    }

    /**
     * 设置APP配置
     *
     * @param configList 配置列表
     */
    @Override
    public void setMultiAppConfig(List<BaiduAiAppProperties> configList) {
        configList.forEach(item -> {
            // 验证参数
            this.validateAppProperties(item);
            ClientCache<T> clientCache = new ClientCache<>(item, null);
            this.clientCacheMap.put(item.getAppId(), clientCache);
        });
    }

    /**
     * 设置APP配置，同时设置默认的APPID
     *
     * @param configList   配置列表
     * @param defaultAppId 默认的APPID
     */
    @Override
    public void setMultiAppConfig(List<BaiduAiAppProperties> configList, String defaultAppId) {
        this.setMultiAppConfig(configList);
        if (!this.clientCacheMap.containsKey(defaultAppId)) {
            throw new BaiduAiException("未找到默认的appid，请检查appid是否正确，defaultAppId：" + defaultAppId);
        }
        this.defaultAppId = defaultAppId;
    }

    /**
     * 获取默认的client
     *
     * @param creator 创建函数
     * @return AipImageClassify
     */
    @Override
    public T getClient(Function<BaiduAiAppProperties, T> creator) {
        if (StringUtils.isBlank(this.defaultAppId)) {
            throw new BaiduAiException("未设置默认的appid");
        }
        return this.getClient(this.defaultAppId, creator);
    }

    /**
     * 通过APPID获取client
     *
     * @param appid   appid
     * @param creator 创建函数
     * @return AipImageClassify
     */
    @Override
    public T getClient(String appid, Function<BaiduAiAppProperties, T> creator) {
        if (appid == null) {
            appid = this.defaultAppId;
        }
        if (StringUtils.isBlank(appid)) {
            throw new BaiduAiException("未设置默认的appid");
        }
        ClientCache<T> clientCache = this.clientCacheMap.get(appid);
        if (clientCache == null) {
            throw new BaiduAiException("获取客户端失败，请检查APPID是否正确，appid：" + appid);
        }
        if (clientCache.getClient() == null) {
            clientCache.setClient(creator.apply(clientCache.getProperties()));
        }
        return clientCache.getClient();
    }
}
