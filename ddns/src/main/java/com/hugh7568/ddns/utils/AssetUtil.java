package com.hugh7568.ddns.utils;

import com.hugh7568.ddns.exception.ProviderException;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * assert 工具类
 *
 * @author Hugh
 */
public class AssetUtil {

    private final static String ERROR_MSG = "参数不能为空";

    public static void isNotNull(Object param) {
        isNotNull(param, ERROR_MSG);
    }

    public static void isNotNull(Object param, String message) {
        if (Objects.nonNull(param)) {
            throw new ProviderException(message);
        }
    }

    public static void isNull(Object param) {
        isNull(param, "参数必须为null!");
    }

    public static void isNull(Object param, String message) {
        if (Objects.isNull(param)) {
            throw new ProviderException(message);
        }
    }

    public static void isNotEmpty(String param) {
        isNotEmpty(param, "字符串不能为空");
    }

    public static void isNotEmpty(String param, String message) {
        if (StringUtils.isNotEmpty(param)) {
            throw new ProviderException(message);
        }
    }

    /**
     * 业务断言
     */
    public static void providerError() {
        throw new ProviderException("供应商请求失败");
    }

    public static void providerError(Object param) {
        if (Objects.isNull(param)) {
            throw new ProviderException("供应商请求失败");
        }
    }

    public static void providerError(Object... params) {
        if (Objects.isNull(params)) {
            throw new ProviderException("供应商请求失败");
        }
        if (params.length == 0) {
            throw new ProviderException("供应商请求失败");
        }
        for (Object param : params) {
            if (Objects.isNull(param)) {
                throw new ProviderException("供应商请求失败");
            }
        }
    }

}
