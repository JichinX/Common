package me.xujichang.lib.common.status;

import androidx.lifecycle.Observer;

public abstract class StatusTipObserver implements Observer<RequestStatus> {
    private final RequestStatus mStatus;

    public StatusTipObserver(RequestStatus pVTargetStatus) {
        mStatus = pVTargetStatus;
    }

    @Override
    public void onChanged(RequestStatus pRequestStatus) {
        if (pRequestStatus == mStatus) {
            onCatchStatus();
        }
    }

    protected abstract void onCatchStatus();
}
