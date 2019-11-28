package com.rivmt.kbd.hangulkeyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

public class MyKeyboardView extends KeyboardView {

    private Context mContext;
    private Keyboard mKeyBoard;

    public MyKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public MyKeyboardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
    }

    @Override
    public void onDraw(Canvas canvas) {

    }
}
