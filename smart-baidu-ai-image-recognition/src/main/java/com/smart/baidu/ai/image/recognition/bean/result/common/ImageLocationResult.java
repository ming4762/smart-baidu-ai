package com.smart.baidu.ai.image.recognition.bean.result.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 位置信息（左起像素位置、上起像素位置、像素宽、像素高）
 * @author zhongming4762
 * 2023/5/4
 */
@Getter
@Setter
public class ImageLocationResult implements Serializable {

    private Long left;

    private Long top;

    private Long width;

    private Long height;
}
