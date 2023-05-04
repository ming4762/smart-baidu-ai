package com.smart.baidu.ai.image.recognition.service;

import cn.hutool.core.io.IoUtil;
import com.smart.baidu.ai.image.recognition.bean.parameter.logo.*;
import com.smart.baidu.ai.image.recognition.bean.result.logo.LogoAddResult;
import com.smart.baidu.ai.image.recognition.bean.result.logo.LogoDeleteResult;
import com.smart.baidu.ai.image.recognition.bean.result.logo.LogoSearchResult;

/**
 * 百度AI logo商标识别
 * @see <a href="https://ai.baidu.com/ai-doc/IMAGERECOGNITION/rk3bcxg71#logo%E5%95%86%E6%A0%87%E8%AF%86%E5%88%AB">百度AI文档</>
 * @author zhongming4762
 * 2023/5/4
 */
public interface LogoService {

    /**
     * logo商标识别
     * @param appid appid
     * @param parameter 参数
     * @return LogoSearchResult
     */
    LogoSearchResult logoSearch(String appid, ByteLogoSearchParameter parameter);

    /**
     * logo商标识别，使用默认的appid
     * @param parameter 参数
     * @return LogoSearchResult
     */
    default LogoSearchResult logoSearch(ByteLogoSearchParameter parameter) {
        return this.logoSearch(null, parameter);
    }

    /**
     * logo商标识别
     * @param appid appid
     * @param parameter 参数
     * @return LogoSearchResult
     */
    default LogoSearchResult logoSearch(String appid, InputStreamLogoSearchParameter parameter) {
        return this.logoSearch(
                appid,
                ByteLogoSearchParameter.builder()
                        .customLib(parameter.getCustomLib())
                        .bytes(IoUtil.readBytes(parameter.getInputStream()))
                        .build()
        );
    }

    /**
     * logo商标识别，使用默认的appid
     * @param parameter 参数
     * @return LogoSearchResult
     */
    default LogoSearchResult logoSearch(InputStreamLogoSearchParameter parameter) {
        return this.logoSearch(null, parameter);
    }

    /**
     * logo商标识别—添加
     * @param appid appid
     * @param parameter 参数
     * @return LogoAddResult
     */
    LogoAddResult logoAdd(String appid, ByteLogoAddParameter parameter);

    /**
     * logo商标识别—添加
     * @param parameter 参数
     * @return LogoAddResult
     */
    default LogoAddResult logoAdd(ByteLogoAddParameter parameter) {
        return this.logoAdd(null, parameter);
    }

    /**
     * logo商标识别—添加
     * @param appid appid
     * @param parameter 参数
     * @return LogoAddResult
     */
    default LogoAddResult logoAdd(String appid, InputStreamLogoAddParameter parameter) {
        return this.logoAdd(
                appid,
                ByteLogoAddParameter.builder()
                        .name(parameter.getName())
                        .code(parameter.getCode())
                        .bytes(IoUtil.readBytes(parameter.getInputStream()))
                        .build()
        );
    }


    /**
     * logo商标识别—添加
     * @param parameter 参数
     * @return LogoAddResult
     */
    default LogoAddResult logoAdd(InputStreamLogoAddParameter parameter) {
        return this.logoAdd(null, parameter);
    }

    /**
     * logo商标识别—删除
     * @param appid appid
     * @param parameter 参数
     * @return LogoDeleteResult
     */
    LogoDeleteResult logoDelete(String appid, ByteLogoDeleteParameter parameter);


    /**
     * logo商标识别—删除
     * @param parameter 参数
     * @return LogoDeleteResult
     */
    default LogoDeleteResult logoDelete(ByteLogoDeleteParameter parameter) {
        return this.logoDelete(null, parameter);
    }

    /**
     * logo商标识别—删除
     * @param appid appid
     * @param parameter 参数
     * @return LogoDeleteResult
     */
    default LogoDeleteResult logoDelete(String appid, InputStreamLogoDeleteParameter parameter) {
        return this.logoDelete(
                appid,
                new ByteLogoDeleteParameter(IoUtil.readBytes(parameter.getInputStream()))
        );
    }

    /**
     * logo商标识别—删除
     * @param parameter 参数
     * @return LogoDeleteResult
     */
    default LogoDeleteResult logoDelete(InputStreamLogoDeleteParameter parameter) {
        return this.logoDelete(null, parameter);
    }

    /**
     * logo商标识别—删除
     * @param appid appid
     * @param contSign 图片签名
     * @return LogoDeleteResult
     */
    LogoDeleteResult logoDelete(String appid, String contSign);

    /**
     * logo商标识别—删除
     * @param contSign 图片签名
     * @return LogoDeleteResult
     */
    default LogoDeleteResult logoDelete(String contSign) {
        return this.logoDelete(null, contSign);
    }
}
