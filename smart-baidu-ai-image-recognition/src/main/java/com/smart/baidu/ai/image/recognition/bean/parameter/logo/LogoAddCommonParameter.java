package com.smart.baidu.ai.image.recognition.bean.parameter.logo;

import com.smart.baidu.ai.common.utils.MapProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * brief，检索时带回。此处要传name与code字段作为标识，name大小小于100B，code大小小于150B
 * @author zhongming4762
 * 2023/5/4
 */
@Getter
@Setter
@SuperBuilder
public class LogoAddCommonParameter implements Serializable {

    @MapProperties
    private String name;

    @MapProperties
    private String code;
}
