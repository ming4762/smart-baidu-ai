package com.smart.baidu.ai.common.utils;

import cn.hutool.core.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhongming4762
 * 2023/5/4
 */
public class BaiduAiUtils {

    private BaiduAiUtils() {
        throw new IllegalStateException("Utility class");
    }

    private static final Map<Class<?>, List<MapPropertiesCache>> MAP_PROPERTIES_CACHE_MAP = new ConcurrentHashMap<>();

    @Getter
    @AllArgsConstructor
    private static class MapPropertiesCache {
        private String mapKey;

        private Field field;
    }

    /**
     * 参数实体类转为map
     * @param parameter 参数实体类
     * @return map类型的参数
     */
    public static HashMap<String, String> parameterToMap(Object parameter) {
        Map<String, Object> map = beanToMap(parameter);
        HashMap<String, String> result = new HashMap<>(map.size());
        map.forEach((key, value) -> result.put(key, value == null ? null : value.toString()));
        return result;
    }

    /**
     * 将实体类转为map
     * @param parameter 实体类
     * @return map
     */
    public static Map<String, Object> beanToMap(Object parameter) {
        // 获取配置信息
        List<MapPropertiesCache> mapPropertiesCacheList = getMapPropertiesCacheList(parameter.getClass());
        Map<String, Object> result = new HashMap<>(mapPropertiesCacheList.size());

        for (MapPropertiesCache mapPropertiesCache : mapPropertiesCacheList) {
            result.put(mapPropertiesCache.getMapKey(), BeanUtil.getProperty(parameter, mapPropertiesCache.getField().getName()));
        }
        return result;
    }

    private static List<MapPropertiesCache> getMapPropertiesCacheList(Class<?> clazz) {
        return MAP_PROPERTIES_CACHE_MAP.computeIfAbsent(clazz, keyClass -> {
            Set<Field> fields = new HashSet<>();
            ReflectUtils.getAllFields(keyClass, fields);
            if (fields.isEmpty()) {
                return new ArrayList<>(0);
            }
            List<MapPropertiesCache> propertiesCacheList = new ArrayList<>();
            for (Field field : fields) {
                MapProperties mapProperties = field.getAnnotation(MapProperties.class);
                if (mapProperties == null) {
                    continue;
                }
                String mapKey = mapProperties.value();
                if (StringUtils.isBlank(mapKey)) {
                    mapKey = field.getName();
                }
                propertiesCacheList.add(new MapPropertiesCache(mapKey, field));
            }
            return propertiesCacheList;
        });
    }
}
