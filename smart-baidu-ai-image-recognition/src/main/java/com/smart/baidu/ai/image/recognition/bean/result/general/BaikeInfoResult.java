package com.smart.baidu.ai.image.recognition.bean.result.general;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 对应识别结果的百科词条名称
 * @author zhongming4762
 * 2023/5/4
 */
@Getter
@Setter
public class BaikeInfoResult implements Serializable {

    @JsonAlias("baike_url")
    private String baikeUrl;

    @JsonAlias("image_url")
    private String imageUrl;

    private String description;
}
