package com.smart.baidu.ai.image.recognition.bean.parameter.dish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.InputStream;

/**
 * @author zhongming4762
 * 2023/5/5
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class InputStreamDishDetectParameter extends DishDetectCommonParameter {

    private InputStream inputStream;
}
