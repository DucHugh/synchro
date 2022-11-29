package com.hugh7568.ddns.exception;

/**
 * 关于请求阿里客户端的异常
 *
 * @author Hugh
 */
public class AlibabaException extends ProviderException {

    /**
     * 基础构造函数
     *
     * @param errorMessage 错误信息
     */
    public AlibabaException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * 基础构造函数
     *
     * @param errorMessage 错误信息
     */
    public AlibabaException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}
