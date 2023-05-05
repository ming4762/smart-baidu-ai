package com.smart.baidu.ai.image.recognition.bean.parameter.dish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author zhongming4762
 * 2023/5/5
 */
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ByteDishDetectParameter extends DishDetectCommonParameter {

    private byte[] bytes;
}
