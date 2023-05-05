package com.smart.baidu.ai.image.recognition.service.impl;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.smart.baidu.ai.common.exception.BaiduAiResultErrorException;
import com.smart.baidu.ai.common.result.BaiduAiErrorResult;
import com.smart.baidu.ai.common.service.impl.BaseSmartBaiduAiServiceImpl;
import com.smart.baidu.ai.common.utils.JsonUtils;
import com.smart.baidu.ai.image.recognition.service.AdvancedGeneralService;
import com.smart.baidu.ai.image.recognition.service.BaiduAiImageService;
import com.smart.baidu.ai.image.recognition.service.DishService;
import com.smart.baidu.ai.image.recognition.service.LogoService;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

/**
 * 图像识别接口实现类
 * @author zhongming4762
 * 2023/5/4
 */
public class BaiduAiImageServiceImpl extends BaseSmartBaiduAiServiceImpl<AipImageClassify> implements BaiduAiImageService {

    private static final String RESULT_ERROR_CODE = "error_code";

    @Getter
    @Setter
    private AdvancedGeneralService advancedGeneralService = new AdvancedGeneralServiceImpl(this);

    @Getter
    @Setter
    private LogoService logoService = new LogoServiceImpl(this);

    @Getter
    @Setter
    private DishService dishService = new DishServiceImpl(this);

    /**
     * 通过appid获取 client
     *
     * @param appid appid
     * @return AipImageClassify
     */
    @Override
    public AipImageClassify getClient(String appid) {
        return this.getClient(appid, properties -> {
            AipImageClassify client = new AipImageClassify(properties.getAppId(), properties.getApiKey(), properties.getSecretKey());
            client.setConnectionTimeoutInMillis((int) properties.getConnectionTimeout().toMillis());
            client.setSocketTimeoutInMillis((int) properties.getSocketTimeout().toMillis());
            if (properties.getHttpProxy() != null) {
                client.setHttpProxy(properties.getHttpProxy().getProxyHost(), properties.getHttpProxy().getProxyPort());
            }
            if (properties.getSocketProxy() != null) {
                client.setHttpProxy(properties.getSocketProxy().getProxyHost(), properties.getSocketProxy().getProxyPort());
            }
            return client;
        });
    }

    /**
     * 解析结果
     *
     * @param json        需要解析的json
     * @param resultClass 结果实体类
     * @return 结果实体类
     */
    @Override
    public <T> T analysisResult(JSONObject json, Class<T> resultClass) {
        if (json.has(RESULT_ERROR_CODE)) {
            throw new BaiduAiResultErrorException(JsonUtils.parse(json.toString(), BaiduAiErrorResult.class));
        }
        return JsonUtils.parse(json.toString(), resultClass);
    }
}
