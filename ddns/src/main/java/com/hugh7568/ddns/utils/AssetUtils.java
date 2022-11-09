package com.hugh7568.ddns.utils;

import com.hugh7568.ddns.exception.ProviderException;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * assert 工具类
 *
 * @author Hugh
 */
public class AssetUtils {


    public static void isNotNull(Object param) {
        isNotNull(param, "参数不能为空!");
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

    public static void isNotEmpty(String param){
        isNotEmpty(param, "字符串不能为空");
    }
    public static void isNotEmpty(String param, String message){
        if (StringUtils.isNotEmpty(param)) {
            throw new ProviderException(message);
        }
    }

}
