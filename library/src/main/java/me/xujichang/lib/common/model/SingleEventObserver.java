package me.xujichang.lib.common.model;

/**
 * Des:
 *
 * @author xujichang
 * Created by xujichang on 2020/6/9.
 * Copyright (c) 2020 xujichang All rights reserved.
 */
public abstract class SingleEventObserver<T> extends InterceptObserver<SingleEvent<T>> {

    protected abstract void onValidChanged(T pContent);

    @Override
    public void onPass(SingleEvent<T> pTSingleEvent) {
        onValidChanged(pTSingleEvent.getContent());
    }

    @Override
    public boolean checkFilter(SingleEvent<T> pTSingleEvent) {
        return pTSingleEvent.isUseful();
    }
}
