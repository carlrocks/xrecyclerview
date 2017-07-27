package com.carlrocks.xrecyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dz on 7/27/2017.
 */
public class BallClipRotateView extends View{

    float scaleFloat1 = 0.10f,scaleFloat2 = 0.15f,degrees = 180;

    public BallClipRotateView(Context context) {
        super(context);
    }

    public BallClipRotateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BallClipRotateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float circleSpacing=12;
        float x = getWidth()/2;
        float y = getHeight()/2;

        Paint paint = new Paint();
        paint.setColor(0xffB5B5B5);
        //draw fill circle
        canvas.save();
        canvas.translate(x, y);
        canvas.scale(scaleFloat1, scaleFloat1);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(0, 0, x / 2.5f, paint);

        canvas.restore();

        canvas.translate(x, y);
        canvas.scale(scaleFloat2, scaleFloat2);
        canvas.rotate(degrees);

        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);

        //draw two arc
        float[] startAngles = new float[]{225,45};
        for (int i = 0; i < 2; i++) {
            RectF rectF=new RectF(-x+circleSpacing,-y+circleSpacing,x-circleSpacing,y-circleSpacing);
            canvas.drawArc(rectF, startAngles[i], 90, false, paint);
        }
    }
}
