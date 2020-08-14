package me.xujichang.lib.common.model;

import androidx.lifecycle.Observer;

public abstract class InterceptObserver<T> implements Observer<T>, IEventFilter<T> {
    @Override
    public void onChanged(T pT) {
        if (checkFilter(pT)) {
            onPass(pT);
        }
    }
}
