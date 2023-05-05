package com.smart.baidu.ai.image.recognition.service.impl;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.smart.baidu.ai.common.utils.BaiduAiUtils;
import com.smart.baidu.ai.image.recognition.bean.parameter.dish.ByteDishDetectParameter;
import com.smart.baidu.ai.image.recognition.bean.result.dish.DishDetectResult;
import com.smart.baidu.ai.image.recognition.service.BaiduAiImageService;
import com.smart.baidu.ai.image.recognition.service.DishService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;

/**
 * @author zhongming4762
 * 2023/5/5
 */
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final BaiduAiImageService baiduAiImageService;

    /**
     * 该请求用于菜品识别。即对于输入的一张图片（可正常解码，且长宽比适宜），输出图片的菜品名称、卡路里信息、置信度。
     *
     * @param appid     appid
     * @param parameter 参数
     * @return DishDetectResult
     */
    @Override
    public DishDetectResult dishDelete(String appid, ByteDishDetectParameter parameter) {
        AipImageClassify client = this.baiduAiImageService.getClient(appid);
        JSONObject jsonObject = client.dishDetect(parameter.getBytes(), BaiduAiUtils.parameterToMap(parameter));
        return this.baiduAiImageService.analysisResult(jsonObject, DishDetectResult.class);
    }
}
