package com.hugh7568.ddns.utils;

import com.hugh7568.ddns.enums.DomainLevel;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * 域名工具
 *
 * @author Hugh
 */
public class DomainUtil {

    private static final String SPOT = ".";

    private static final String ERROR_MSG = "请教正域名!";


    /**
     * 通过出入域名进行解析
     * 通过"."进行分割
     *
     * @param domain 域名
     * @return 域名等级
     */
    public static DomainLevel getDomainLevel(String domain) {

        if (StringUtils.contains(domain, SPOT)) {
            //包含多少分隔符
            int spotCount = StringUtils.countMatches(domain, SPOT);

            //查询域名
            return Arrays.stream(DomainLevel.values())
                    .filter(level -> level.ordinal() == spotCount - 1)
                    .findAny()
                    .orElseThrow(() -> new RuntimeException(ERROR_MSG));
        } else {
            throw new RuntimeException(ERROR_MSG);
        }
    }
}
