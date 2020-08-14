package me.xujichang.lib.common.model;

import androidx.lifecycle.Lifecycle;

public abstract class LifecycleAtLastSingleObserver<T> extends SingleEventObserver<T> implements ILifecycleAtLast {
    private final Lifecycle mLifecycle;
    private final Lifecycle.State mState;

    public LifecycleAtLastSingleObserver(Lifecycle pLifecycle, Lifecycle.State pState) {
        mLifecycle = pLifecycle;
        mState = pState;
    }

    @Override
    public boolean checkFilter(SingleEvent<T> pTSingleEvent) {
        return super.checkFilter(pTSingleEvent) && checkAtLast();
    }

    private boolean checkAtLast() {
        return mLifecycle.getCurrentState().isAtLeast(mState);
    }
}
