package com.exmaple2.play_task.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimpleLineChartView extends View {

    private Paint linePaint;
    private Paint pointPaint;
    private Path linePath;
    private List<Float> dataPoints; // 这是你的数据点，x 为 index * xStep, y 为实际数据值

    public SimpleLineChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // 初始化画笔
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(0xFF0000FF); // 蓝色
        linePaint.setStrokeWidth(5f);
        linePaint.setStyle(Paint.Style.STROKE);

        pointPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pointPaint.setColor(0xFFFF0000); // 红色
        pointPaint.setStyle(Paint.Style.FILL);

        linePath = new Path();
        dataPoints = new ArrayList<>();
    }

    public void setData(List<Float> dataPoints) {
        this.dataPoints = dataPoints;
        invalidate(); // 请求重绘视图
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (dataPoints == null || dataPoints.size() < 2) {
            // 数据点太少，不绘制
            return;
        }

        float xStep = getWidth() / (float) (dataPoints.size() - 1);
        float maxDataValue = getMaxDataValue();
        float scale = getHeight() / maxDataValue;

        // 绘制线条
        linePath.reset();
        linePath.moveTo(0, getHeight() - dataPoints.get(0) * scale);
        for (int i = 1; i < dataPoints.size(); i++) {
            linePath.lineTo(xStep * i, getHeight() - dataPoints.get(i) * scale);
        }
        canvas.drawPath(linePath, linePaint);

        // 绘制点
        for (int i = 0; i < dataPoints.size(); i++) {
            canvas.drawCircle(xStep * i, getHeight() - dataPoints.get(i) * scale, 10, pointPaint);
        }
    }

    private float getMaxDataValue() {
        float max = Float.MIN_VALUE;
        for (Float value : dataPoints) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
