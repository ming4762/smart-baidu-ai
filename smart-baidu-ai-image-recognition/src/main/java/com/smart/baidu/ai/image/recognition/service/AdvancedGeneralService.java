package com.smart.baidu.ai.image.recognition.service;

import cn.hutool.core.io.IoUtil;
import com.smart.baidu.ai.image.recognition.bean.parameter.general.ByteAdvancedGeneralParameter;
import com.smart.baidu.ai.image.recognition.bean.parameter.general.InputStreamAdvancedGeneralParameter;
import com.smart.baidu.ai.image.recognition.bean.parameter.general.LocalPathAdvancedGeneralParameter;
import com.smart.baidu.ai.image.recognition.bean.result.general.AdvancedGeneralResult;

/**
 * 通用物体和场景识别
 * @see <a href="https://ai.baidu.com/ai-doc/IMAGERECOGNITION/rk3bcxg71#%E9%80%9A%E7%94%A8%E7%89%A9%E4%BD%93%E5%92%8C%E5%9C%BA%E6%99%AF%E8%AF%86%E5%88%AB">百度AI文档</>
 * @author zhongming4762
 * 2023/5/4
 */
public interface AdvancedGeneralService {

    /**
     * 通用物体和场景识别 参数为本地图片路径
     * @param parameter 参数
     * @return AdvancedGeneralResult
     */
    default AdvancedGeneralResult advancedGeneral(LocalPathAdvancedGeneralParameter parameter) {
        return this.advancedGeneral(null, parameter);
    }

    /**
     * 通用物体和场景识别 参数为本地图片路径
     * @param appid APPID
     * @param parameter 参数
     * @return AdvancedGeneralResult
     */
    AdvancedGeneralResult advancedGeneral(String appid, LocalPathAdvancedGeneralParameter parameter);

    /**
     * 通用物体和场景识别 参数为二进制数组
     * @param parameter 参数
     * @return AdvancedGeneralResult
     */
    default AdvancedGeneralResult advancedGeneral(ByteAdvancedGeneralParameter parameter) {
        return this.advancedGeneral(null, parameter);
    }

    /**
     * 通用物体和场景识别 参数为二进制数组
     * @param appid APPID
     * @param parameter 参数
     * @return AdvancedGeneralResult
     */
    AdvancedGeneralResult advancedGeneral(String appid, ByteAdvancedGeneralParameter parameter);

    /**
     * 通用物体和场景识别 参数为输入流
     * @param parameter 参数
     * @return AdvancedGeneralResult
     */
    default AdvancedGeneralResult advancedGeneral(InputStreamAdvancedGeneralParameter parameter) {
        return this.advancedGeneral(null, parameter);
    }

    /**
     * 通用物体和场景识别 参数为输入流
     * @param appid APPID
     * @param parameter 参数
     * @return AdvancedGeneralResult
     */
    default AdvancedGeneralResult advancedGeneral(String appid, InputStreamAdvancedGeneralParameter parameter) {
        return this.advancedGeneral(
                appid,
                ByteAdvancedGeneralParameter.builder()
                        .baikeNum(parameter.getBaikeNum())
                        .bytes(IoUtil.readBytes(parameter.getInputStream()))
                        .build()
        );
    }
}
