package com.example.admin.pandatv.model.modelutils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by admin on 2017/8/12.
 */

public class ify_List extends ListView {
    public ify_List(Context context) {
        super(context);
    }
    public ify_List(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ify_List(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec  = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);


    }
}

