package me.xujichang.lib.common.status;

/**
 * Des:
 *
 * @author xujichang
 * Created by xujichang on 2020/6/9.
 * Copyright (c) 2020 xujichang All rights reserved.
 */
public enum RequestStatus {
    /**
     * 进行中
     */
    RUNNING(false),
    /**
     * 暂停
     */
    PAUSED(false),
    /**
     * 取消
     */
    CLEARED(false),
    /**
     * 成功
     */
    SUCCESS(true),
    /**
     * 失败
     */
    FAILED(true),

    TIP(true);

    private boolean isComplete;
    private String mErrorInfo;
    private String mMessage;

    public String getErrorInfo() {
        return mErrorInfo;
    }

    public void setErrorInfo(String pErrorInfo) {
        mErrorInfo = pErrorInfo;
    }

    RequestStatus(boolean pIsComplete) {
        isComplete = pIsComplete;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean pComplete) {
        isComplete = pComplete;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String pMessage) {
        mMessage = pMessage;
    }

    @Override
    public String toString() {
        return "RequestStatus{" +
                "isComplete=" + isComplete +
                ", mErrorInfo='" + mErrorInfo + '\'' +
                ", mMessage='" + mMessage + '\'' +
                '}';
    }
}
