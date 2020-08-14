package me.xujichang.lib.common.widget.edit.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatEditText;

import me.xujichang.lib.common.widget.edit.ISelectionListener;


public class SelectionEditText extends AppCompatEditText {
    private ISelectionListener mSelectionListener;
    private static final String TAG = "SelectionEditText";

    public SelectionEditText(Context context) {
        super(context);
    }

    public SelectionEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectionEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        Log.d(TAG, "onSelectionChanged() called with: selStart = [" + selStart + "], selEnd = [" + selEnd + "]");
        if (null != mSelectionListener) {
            mSelectionListener.onSelection(selStart, selEnd);
        }
    }

    public void setSelectionListener(ISelectionListener pSelectionListener) {
        mSelectionListener = pSelectionListener;
    }
}
