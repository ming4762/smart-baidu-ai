package com.smart.baidu.ai.image.recognition.bean.result.dish;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.smart.baidu.ai.image.recognition.bean.result.common.BaikeInfoResult;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 菜品识别 返回数据
 * @author zhongming4762
 * 2023/5/5
 */
@Getter
@Setter
public class DishDetectResult implements Serializable {

    /**
     * 唯一的log id，用于问题定位
     */
    @JsonAlias("log_id")
    private Long logId;

    /**
     * 返回结果数目，及result数组中的元素个数
     */
    @JsonAlias("result_num")
    private Integer resultNum;


    private List<Result> result;

    @Getter
    @Setter
    public static class Result implements Serializable {
        /**
         * 菜名，示例：鱼香肉丝
         */
        private String name;

        /**
         * 卡路里，每100g的卡路里含量
         */
        private Double calorie;

        /**
         * 识别结果中每一行的置信度值，0-1
         */
        private Double probability;

        @JsonAlias("baike_info")
        private BaikeInfoResult baikeInfo;
    }
}
