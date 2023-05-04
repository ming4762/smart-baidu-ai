package com.smart.baidu.ai.common.service;

import com.smart.baidu.ai.common.properties.BaiduAiAppProperties;

import java.util.List;
import java.util.function.Function;

/**
 * 百度AI服务类
 * @author zhongming4762
 * 2023/5/4
 */
public interface SmartBaiduAiService<T> {

    /**
     * 验证APP参数
     * @param properties 参数
     * @return 验证结果
     */
    boolean validateAppProperties(BaiduAiAppProperties properties);


    /**
     * 设置APP配置
     * @param configList 配置列表
     */
    void setMultiAppConfig(List<BaiduAiAppProperties> configList);

    /**
     * 设置APP配置，同时设置默认的APPID
     * @param configList 配置列表
     * @param defaultAppId 默认的APPID
     */
    void setMultiAppConfig(List<BaiduAiAppProperties> configList, String defaultAppId);

    /**
     * 获取默认的client
     * @param creator 创建函数
     * @return AipImageClassify
     */
    T getClient(Function<BaiduAiAppProperties, T> creator);

    /**
     * 通过APPID获取client
     * @param appid appid
     * @param creator 创建函数
     * @return AipImageClassify
     */
    T getClient(String appid, Function<BaiduAiAppProperties, T> creator);
}
