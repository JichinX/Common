package me.xujichang.lib.common.livedata;

import androidx.lifecycle.MutableLiveData;

public class ValueChangeLiveData<T> extends MutableLiveData<T> {
    private T mLastValue;

    public ValueChangeLiveData(T value) {
        super(value);
        mLastValue = value;
    }

    public ValueChangeLiveData() {
    }

    @Override
    public void postValue(T value) {
        if (null != mLastValue && mLastValue.equals(value)) {
            return;
        }
        mLastValue = value;
        super.postValue(value);
    }

    @Override
    public void setValue(T value) {
        if (null != mLastValue && mLastValue.equals(value)) {
            return;
        }
        mLastValue = value;
        super.setValue(value);
    }
}
