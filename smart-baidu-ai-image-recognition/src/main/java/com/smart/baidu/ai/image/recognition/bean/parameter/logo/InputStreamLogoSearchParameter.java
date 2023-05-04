package com.smart.baidu.ai.image.recognition.bean.parameter.logo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.InputStream;

/**
 * @author zhongming4762
 * 2023/5/4
 */
@Getter
@Setter
@SuperBuilder
public class InputStreamLogoSearchParameter extends LogoSearchCommonParameter {

    private InputStream inputStream;
}
