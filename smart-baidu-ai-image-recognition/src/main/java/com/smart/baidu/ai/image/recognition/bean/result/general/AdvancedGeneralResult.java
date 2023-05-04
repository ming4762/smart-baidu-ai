package com.smart.baidu.ai.image.recognition.bean.result.general;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.smart.baidu.ai.image.recognition.bean.result.common.BaikeInfoResult;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 通用物体和场景识别返回结果
 * @author zhongming4762
 * 2023/5/4
 */
@Getter
@Setter
public class AdvancedGeneralResult implements Serializable {

    @JsonAlias("log_id")
    private Long logId;

    @JsonAlias("result_num")
    private Integer resultNum;

    @Setter
    private List<Result> result;

    @Getter
    @Setter
    public static class Result implements Serializable {
        private String keyword;

        private Double score;

        private String root;

        @JsonAlias("baike_info")
        private BaikeInfoResult baikeInfo;
    }

}
