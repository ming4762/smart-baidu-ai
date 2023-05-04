package com.smart.baidu.ai.image.recognition.bean.parameter.general;

import com.smart.baidu.ai.common.utils.MapProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 通用物体和场景识别 通用参数
 * @author zhongming4762
 * 2023/5/4
 */
@Getter
@Setter
@SuperBuilder
public class AdvancedGeneralCommonParameter implements Serializable {

    /**
     * 返回百科信息的结果数，默认不返回
     */
    @MapProperties("baike_num")
    private Integer baikeNum = 0;
}
