package me.xujichang.lib.common.status;

import androidx.lifecycle.Observer;

public abstract class StatusCallbackObserver implements Observer<RequestStatus> {
    private RequestStatus mStatus;

    public StatusCallbackObserver(RequestStatus pStatus) {
        mStatus = pStatus;
    }

    public StatusCallbackObserver() {
    }

    @Override
    public void onChanged(RequestStatus pRequestStatus) {
        if (null == mStatus || mStatus == pRequestStatus) {
            onTargetCallback();
        }
    }

    protected abstract void onTargetCallback();
}
