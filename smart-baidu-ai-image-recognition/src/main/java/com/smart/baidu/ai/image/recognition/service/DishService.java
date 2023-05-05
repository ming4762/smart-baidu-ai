package com.smart.baidu.ai.image.recognition.service;

import cn.hutool.core.io.IoUtil;
import com.smart.baidu.ai.image.recognition.bean.parameter.dish.ByteDishDetectParameter;
import com.smart.baidu.ai.image.recognition.bean.parameter.dish.InputStreamDishDetectParameter;
import com.smart.baidu.ai.image.recognition.bean.result.dish.DishDetectResult;

/**
 * 菜品识别接口
 * @see <a href="https://ai.baidu.com/ai-doc/IMAGERECOGNITION/rk3bcxg71#%E8%8F%9C%E5%93%81%E8%AF%86%E5%88%AB">百度AI文档</>
 * @author zhongming4762
 * 2023/5/5 9:01
 */
public interface DishService {

    /**
     * 该请求用于菜品识别。即对于输入的一张图片（可正常解码，且长宽比适宜），输出图片的菜品名称、卡路里信息、置信度。
     * @param appid appid
     * @param parameter 参数
     * @return DishDetectResult
     */
    DishDetectResult dishDelete(String appid, ByteDishDetectParameter parameter);

    /**
     * 该请求用于菜品识别。即对于输入的一张图片（可正常解码，且长宽比适宜），输出图片的菜品名称、卡路里信息、置信度。
     * @param parameter 参数
     * @return DishDetectResult
     */
    default DishDetectResult dishDelete(ByteDishDetectParameter parameter) {
        return this.dishDelete(null, parameter);
    }

    /**
     * 该请求用于菜品识别。即对于输入的一张图片（可正常解码，且长宽比适宜），输出图片的菜品名称、卡路里信息、置信度。
     * @param appid appid
     * @param parameter 参数
     * @return DishDetectResult
     */
    default DishDetectResult dishDelete(String appid, InputStreamDishDetectParameter parameter) {
        return this.dishDelete(
                appid,
                ByteDishDetectParameter.builder()
                        .topNum(parameter.getTopNum())
                        .filterThreshold(parameter.getFilterThreshold())
                        .baikeNum(parameter.getBaikeNum())
                        .bytes(IoUtil.readBytes(parameter.getInputStream()))
                        .build()
        );
    }

    /**
     * 该请求用于菜品识别。即对于输入的一张图片（可正常解码，且长宽比适宜），输出图片的菜品名称、卡路里信息、置信度。
     * @param parameter 参数
     * @return DishDetectResult
     */
    default DishDetectResult dishDelete(InputStreamDishDetectParameter parameter) {
        return this.dishDelete(null, parameter);
    }
}
