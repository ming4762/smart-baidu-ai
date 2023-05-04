package com.smart.baidu.ai.image.recognition.service.impl;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.smart.baidu.ai.common.utils.BaiduAiUtils;
import com.smart.baidu.ai.image.recognition.bean.parameter.general.ByteAdvancedGeneralParameter;
import com.smart.baidu.ai.image.recognition.bean.parameter.general.LocalPathAdvancedGeneralParameter;
import com.smart.baidu.ai.image.recognition.bean.result.general.AdvancedGeneralResult;
import com.smart.baidu.ai.image.recognition.service.AdvancedGeneralService;
import com.smart.baidu.ai.image.recognition.service.BaiduAiImageService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;

/**
 * @author zhongming4762
 * 2023/5/4
 */
@RequiredArgsConstructor
public class AdvancedGeneralServiceImpl implements AdvancedGeneralService {

    private final BaiduAiImageService baiduAiImageService;

    /**
     * 通用物体和场景识别 参数为本地图片路径
     *
     * @param appid     APPID
     * @param parameter 参数
     * @return AdvancedGeneralResult
     */
    @Override
    public AdvancedGeneralResult advancedGeneral(String appid, LocalPathAdvancedGeneralParameter parameter) {
        AipImageClassify client = this.baiduAiImageService.getClient(appid);
        JSONObject jsonObject = client.advancedGeneral(parameter.getLocalPath(), BaiduAiUtils.parameterToMap(parameter));
        return this.baiduAiImageService.analysisResult(jsonObject, AdvancedGeneralResult.class);
    }

    /**
     * 通用物体和场景识别 参数为二进制数组
     *
     * @param appid     APPID
     * @param parameter 参数
     * @return AdvancedGeneralResult
     */
    @Override
    public AdvancedGeneralResult advancedGeneral(String appid, ByteAdvancedGeneralParameter parameter) {
        AipImageClassify client = this.baiduAiImageService.getClient(appid);
        JSONObject jsonObject = client.advancedGeneral(parameter.getBytes(), BaiduAiUtils.parameterToMap(parameter));
        return this.baiduAiImageService.analysisResult(jsonObject, AdvancedGeneralResult.class);
    }
}
