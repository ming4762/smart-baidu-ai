package com.smart.baidu.ai.image.recognition.bean.parameter.general;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author zhongming4762
 * 2023/5/4
 */
@Getter
@Setter
@SuperBuilder
public class ByteAdvancedGeneralParameter extends AdvancedGeneralCommonParameter {

    private byte[] bytes;
}
