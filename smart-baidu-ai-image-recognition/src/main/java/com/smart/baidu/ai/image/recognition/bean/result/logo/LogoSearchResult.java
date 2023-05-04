package com.smart.baidu.ai.image.recognition.bean.result.logo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.smart.baidu.ai.image.recognition.bean.result.common.ImageLocationResult;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Logo识别返回结果
 * @author zhongming4762
 * 2023/5/4
 */
@Getter
@Setter
public class LogoSearchResult implements Serializable {
    @JsonAlias("log_id")
    private Long logId;

    @JsonAlias("result_num")
    private Integer resultNum;

    /**
     * 返回结果数组，每一项为一个识别出的logo
     */
    private List<Result> result;


    @Getter
    @Setter
    public static class Result implements Serializable {

        /**
         * 位置信息（左起像素位置、上起像素位置、像素宽、像素高）
         */
        private ImageLocationResult location;

        /**
         * 识别的品牌名称
         */
        private String name;

        /**
         * 分类结果置信度（0--1.0）
         */
        private Double probability;

        /**
         * type=0为1千种高优商标识别结果;type=1为2万类logo库的结果；其它type为自定义logo库结果
         */
        private Integer type;
    }
}
