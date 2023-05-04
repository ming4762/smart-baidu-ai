package com.smart.baidu.ai.image.recognition.bean.parameter.logo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author zhongming4762
 * 2023/5/4
 */
@Getter
@Setter
@SuperBuilder
public class LogoSearchCommonParameter implements Serializable {

    /**
     * 是否只使用自定义logo库的结果，默认false：返回自定义库+默认库的识别结果
     * true - 返回自定义库
     * false - 返回自定义库+默认库的识别结果
     */
    @Builder.Default
    private Boolean customLib = Boolean.FALSE;
}
