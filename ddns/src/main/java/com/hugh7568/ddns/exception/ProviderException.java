package com.hugh7568.ddns.exception;

/**
 * 运营商异常
 *
 * @author Hugh
 */
public class ProviderException extends RuntimeException {

    /**
     * 基础构造函数
     */
    public ProviderException(String errorMessage) {
        super(errorMessage);
    }

    public ProviderException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}
