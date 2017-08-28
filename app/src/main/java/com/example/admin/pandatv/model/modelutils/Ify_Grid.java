package com.example.admin.pandatv.model.modelutils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by dell on 2017/7/12.
 */

public class Ify_Grid extends GridView {
    public Ify_Grid(Context context) {
        super(context);
    }

    public Ify_Grid(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Ify_Grid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec  = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);


    }
}
