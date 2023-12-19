package com.exmaple2.play_task.data;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomChartView extends View {
    private Paint paint;

    public CustomChartView(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomChartView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // 初始化画笔
        paint = new Paint();
        paint.setColor(Color.BLUE); // 设置画笔颜色
        paint.setStrokeWidth(5f); // 设置线条宽度
        paint.setStyle(Paint.Style.STROKE); // 设置样式为描边
        paint.setAntiAlias(true); // 设置抗锯齿
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制一个简单的线条作为示例
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, paint);
    }
}
