package me.xujichang.lib.common.rx;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import com.jakewharton.rxbinding3.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/**
 * me.xujichang.lib.activities.util in Activities
 * description:
 * <p>
 * created by xujichang at 2020/4/28 7:11 PM
 * 对View的处理
 *
 * @author xujichang
 */
public class RxViews implements LifecycleEventObserver {
    public static final long DEFAULT_DURATION = 500;
    /**
     * 根据LifecycleOwner 作为标识 存储RxViews
     */
    private CompositeDisposable mDisposables;

    private RxViews(LifecycleOwner pOwner) {
        pOwner.getLifecycle().addObserver(this);
    }

    public static RxViews getInstance(LifecycleOwner pOwner) {
        return new RxViews(pOwner);
    }

    public void click(View view, final View.OnClickListener onClickListener) {
        click(view, onClickListener, DEFAULT_DURATION);
    }

    public void click(View view, final View.OnClickListener onClickListener, long ms) {
        addDisposable(RxView.clicks(view)
                .throttleFirst(ms, TimeUnit.MILLISECONDS)
                .subscribe(new ViewClickConsumer(view, onClickListener)));
    }

    private void addDisposable(Disposable pSubscribe) {
        getDisposables().add(pSubscribe);
    }

    private void dispose() {
        getDisposables().dispose();
    }

    public CompositeDisposable getDisposables() {
        if (null == mDisposables) {
            mDisposables = new CompositeDisposable();
        }
        return mDisposables;
    }

    @Override
    public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
        switch (event) {
            case ON_DESTROY:
                dispose();
                break;
            default:
                break;
        }
    }

    private static class ViewClickConsumer implements Consumer<Unit> {
        private View mView;
        private View.OnClickListener mListener;

        public ViewClickConsumer(View pView, View.OnClickListener pListener) {
            mView = pView;
            mListener = pListener;
        }

        @Override
        public void accept(Unit pUnit) throws Exception {
            mListener.onClick(mView);
        }
    }
}
