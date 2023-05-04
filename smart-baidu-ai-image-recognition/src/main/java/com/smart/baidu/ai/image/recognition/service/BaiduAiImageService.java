package com.smart.baidu.ai.image.recognition.service;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.smart.baidu.ai.common.service.SmartBaiduAiService;
import org.json.JSONObject;

/**
 * @author zhongming4762
 * 2023/5/4 14:10
 */
public interface BaiduAiImageService extends SmartBaiduAiService<AipImageClassify> {

    /**
     * 获取 通用物体和场景识别 服务类
     * @return AdvancedGeneralService
     */
    AdvancedGeneralService getAdvancedGeneralService();

    /**
     * 获取默认的client
     * @return AipImageClassify
     */
    default AipImageClassify getClient() {
        return this.getClient((String) null);
    }

    /**
     * 通过appid获取 client
     * @param appid appid
     * @return AipImageClassify
     */
    AipImageClassify getClient(String appid);

    /**
     * 解析结果
     * @param json 需要解析的json
     * @param resultClass 结果实体类
     * @return 结果实体类
     * @param <T> 实体类类型
     */
    <T> T analysisResult(JSONObject json, Class<T> resultClass);
}
