package me.xujichang.lib.common.model;

import androidx.lifecycle.Observer;

public class LifecycleAtLeastEvent<T> implements Observer<T>, ILifecycleAtLast {
    @Override
    public void onChanged(T pT) {

    }
}
