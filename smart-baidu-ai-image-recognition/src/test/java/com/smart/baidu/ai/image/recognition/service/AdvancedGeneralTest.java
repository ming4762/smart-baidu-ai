package com.smart.baidu.ai.image.recognition.service;

import com.google.common.collect.ImmutableList;
import com.smart.baidu.ai.common.properties.BaiduAiAppProperties;
import com.smart.baidu.ai.common.utils.JsonUtils;
import com.smart.baidu.ai.image.recognition.bean.parameter.general.InputStreamAdvancedGeneralParameter;
import com.smart.baidu.ai.image.recognition.bean.parameter.general.LocalPathAdvancedGeneralParameter;
import com.smart.baidu.ai.image.recognition.bean.result.general.AdvancedGeneralResult;
import com.smart.baidu.ai.image.recognition.service.impl.BaiduAiImageServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author zhongming4762
 * 2023/5/4 18:11
 */
@DisplayName("通用物体和场景识别测试")
@Slf4j
class AdvancedGeneralTest {

    private static BaiduAiImageService baiduAiImageService;

    @BeforeAll
    public static void initService() {
        BaiduAiImageServiceImpl aiImageService = new BaiduAiImageServiceImpl();
        aiImageService.setMultiAppConfig(
                ImmutableList.of(
                        BaiduAiAppProperties.builder()
                                .appId("33159405")
                                .apiKey("r7SuFLRmQeT9GRWoMANe4u31")
                                .secretKey("L7foM5EvbUcXqq5yEFKlv4YyWnKnGw5I")
                                .build()
                ),
                "33159405"
        );
        baiduAiImageService = aiImageService;
    }

    @DisplayName("本地文件测试")
    @Test
    void testLocalPathAdvancedGeneral() {
        AdvancedGeneralResult result = baiduAiImageService.getAdvancedGeneralService().advancedGeneral(
                LocalPathAdvancedGeneralParameter.builder()
                        .localPath("E:\\01-联亚\\02-项目\\08-汉鼎配节管理系统\\开发资料\\产品照片\\产品照片\\角度图\\汉鼎战\\0P8A1180.JPG")
                        .build()
        );
        log.info(JsonUtils.toJsonString(result));
        Assertions.assertNotNull(result);
    }

    @SneakyThrows(IOException.class)
    @DisplayName("测试文件流识别")
    @Test
    void testInputStreamAdvancedGeneral() {
        try (InputStream inputStream = Files.newInputStream(Paths.get("E:\\01-联亚\\02-项目\\08-汉鼎配节管理系统\\开发资料\\产品照片\\产品照片\\角度图\\汉鼎战\\0P8A1180.JPG"))) {
            AdvancedGeneralResult result = baiduAiImageService.getAdvancedGeneralService().advancedGeneral(
                    InputStreamAdvancedGeneralParameter.builder()
                            .inputStream(inputStream)
                            .build()
            );
            log.info(JsonUtils.toJsonString(result));
            Assertions.assertNotNull(result);
        }
    }
}
