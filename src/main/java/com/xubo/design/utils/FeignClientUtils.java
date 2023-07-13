package com.xubo.design.utils;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.beans.BeansException;
import org.springframework.cloud.openfeign.FeignClientBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author xubo
 * @Date 2023/7/10 17:50
 * @Description：
 * @Version 1.0
 */
@Component
public class FeignClientUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;
    private static final Map<String, Object> BEAN_CACHE = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(FeignClientUtils.applicationContext == null) {
            FeignClientUtils.applicationContext = applicationContext;
        }
    }

    public static<T> T build(String serverName, Class<T> targetClass) {
        return buildClient(serverName, targetClass);
    }

    @SuppressWarnings("unchecked")
    private static <T> T buildClient(String serverName, Class<T> targetClass) {
        T t = (T) BEAN_CACHE.get(serverName);
        if(ObjectUtil.isNull(t)) {
            FeignClientBuilder.Builder<T> builder = new FeignClientBuilder(applicationContext).forType(targetClass, serverName);
            t = builder.build();
            BEAN_CACHE.put(serverName, t);
        }
        return t;
    }
}
