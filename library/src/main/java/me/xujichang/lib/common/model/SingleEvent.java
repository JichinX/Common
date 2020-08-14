package me.xujichang.lib.common.model;

/**
 * Des:只发送一次的事件，用于解决ViewModel内LivData导致的"数据倒灌现象"
 *
 * @author xujichang
 * Created by xujichang on 2020/6/9.
 * Copyright (c) 2020 xujichang All rights reserved.
 */
public class SingleEvent<T> {
    /**
     * 是否被消费掉
     */
    private boolean consumed = false;
    /**
     * 此次事件的真正内容
     */
    private T content;
    /**
     * 唯一Code 做区分
     */
    private int code = 0;

    public SingleEvent(T pContent) {
        content = pContent;
    }

    public SingleEvent(T pContent, int pUniqueCode) {
        content = pContent;
        code = pUniqueCode;
    }

    /**
     * 仅仅取一下事件的内容，不消费事件
     *
     * @return
     */
    public T peekContent() {
        return content;
    }

    public int getCode() {
        return code;
    }

    /**
     * 直接取  会将事件消费掉
     *
     * @return
     */
    public T getContent() {
        if (consumed) {
            return null;
        } else {
            consumed = true;
            return content;
        }
    }

    public boolean isUseful() {
        return !consumed;
    }
}
