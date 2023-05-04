package com.smart.baidu.ai.image.recognition.bean.parameter.logo;

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
public class ByteLogoSearchParameter extends LogoSearchCommonParameter {

    private byte[] bytes;

}
