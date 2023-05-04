package com.smart.baidu.ai.image.recognition.service.impl;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.smart.baidu.ai.common.utils.BaiduAiUtils;
import com.smart.baidu.ai.common.utils.JsonUtils;
import com.smart.baidu.ai.image.recognition.bean.parameter.logo.ByteLogoAddParameter;
import com.smart.baidu.ai.image.recognition.bean.parameter.logo.ByteLogoDeleteParameter;
import com.smart.baidu.ai.image.recognition.bean.parameter.logo.ByteLogoSearchParameter;
import com.smart.baidu.ai.image.recognition.bean.result.logo.LogoAddResult;
import com.smart.baidu.ai.image.recognition.bean.result.logo.LogoDeleteResult;
import com.smart.baidu.ai.image.recognition.bean.result.logo.LogoSearchResult;
import com.smart.baidu.ai.image.recognition.service.BaiduAiImageService;
import com.smart.baidu.ai.image.recognition.service.LogoService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author zhongming4762
 * 2023/5/4
 */
@RequiredArgsConstructor
public class LogoServiceImpl implements LogoService {

    private final BaiduAiImageService baiduAiImageService;

    /**
     * logo商标识别
     *
     * @param appid     appid
     * @param parameter 参数
     * @return LogoSearchResult
     */
    @Override
    public LogoSearchResult logoSearch(String appid, ByteLogoSearchParameter parameter) {
        AipImageClassify client = this.baiduAiImageService.getClient(appid);
        HashMap<String, String> options = new HashMap<>(1);
        options.put("custom_lib", parameter.getCustomLib().toString());
        JSONObject jsonObject = client.logoSearch(parameter.getBytes(), options);
        return this.baiduAiImageService.analysisResult(jsonObject, LogoSearchResult.class);
    }

    /**
     * logo商标识别—添加
     *
     * @param appid     appid
     * @param parameter 参数
     * @return LogoAddResult
     */
    @Override
    public LogoAddResult logoAdd(String appid, ByteLogoAddParameter parameter) {
        AipImageClassify client = this.baiduAiImageService.getClient(appid);
        JSONObject jsonObject = client.logoAdd(parameter.getBytes(), JsonUtils.toJsonString(BaiduAiUtils.parameterToMap(parameter)), new HashMap<>(0));
        return this.baiduAiImageService.analysisResult(jsonObject, LogoAddResult.class);
    }

    /**
     * logo商标识别—删除
     *
     * @param appid     appid
     * @param parameter 参数
     * @return LogoDeleteResult
     */
    @Override
    public LogoDeleteResult logoDelete(String appid, ByteLogoDeleteParameter parameter) {
        AipImageClassify client = this.baiduAiImageService.getClient(appid);
        JSONObject jsonObject = client.logoDeleteByImage(parameter.getBytes(), new HashMap<>(0));
        return this.baiduAiImageService.analysisResult(jsonObject, LogoDeleteResult.class);
    }

    /**
     * logo商标识别—删除
     *
     * @param appid    appid
     * @param contSign 图片签名
     * @return LogoDeleteResult
     */
    @Override
    public LogoDeleteResult logoDelete(String appid, String contSign) {
        AipImageClassify client = this.baiduAiImageService.getClient(appid);
        JSONObject jsonObject = client.logoDeleteBySign(contSign, new HashMap<>(0));
        return this.baiduAiImageService.analysisResult(jsonObject, LogoDeleteResult.class);
    }

}
