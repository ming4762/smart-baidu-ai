package com.smart.baidu.ai.image.recognition.bean.parameter.dish;

import com.smart.baidu.ai.common.utils.MapProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author zhongming4762
 * 2023/5/5
 */
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishDetectCommonParameter implements Serializable {

    /**
     * 返回预测得分top结果数，默认为5
     */
    @MapProperties("top_num")
    @Builder.Default
    private Integer topNum = 5;

    @MapProperties("filter_threshold")
    @Builder.Default
    private Double filterThreshold = 0.95;

    @MapProperties("baike_num")
    @Builder.Default
    private Integer baikeNum = 0;
}
