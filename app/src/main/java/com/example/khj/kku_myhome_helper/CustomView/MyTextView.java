package com.example.khj.kku_myhome_helper.CustomView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by KHJ on 2017-01-31.
 */

public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text.toString().replace(" ", "\u00A0"), type);
    }
}