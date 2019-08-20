package com.bawei.liyizhi0819.view.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * <p>文件描述：<p>
 * <p>作者：志哥<p>
 * <p>创建时间：2019/8/19<p>
 * <p>更改时间：2019/8/19<p>
 * <p>版本号：1<p>
 */
public class ZiDingyi extends View {

    private char[] zimu = new char[26];
    private int width;
    private int height;
    private int every;
    private Paint paint;
    private int index;

    public ZiDingyi(Context context) {
        this(context, null);
    }

    public ZiDingyi(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ZiDingyi(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initstr();
    }


    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(20);
    }

    private void initstr() {
        for (int i = 0; i < zimu.length; i++) {
            zimu[i] = (char) (i + (char) 'A');
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        width = getWidth();
        height = getHeight();
        paint.setTextSize(20);
        int top = 100;
        int bottom =height -100;
        int total = bottom - top;
        every = total / zimu.length;
        int starty = top + every / 2;
        for (int i = 0; i < zimu.length; i++) {
            canvas.drawText(zimu[i] + "", width - 20, starty + every * i, paint);
        }
        paint.setTextSize(50);
        canvas.drawText(zimu[index] + "", width / 2, height / 2, paint);
        Toast.makeText(getContext(), zimu[index]+"", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

     float x=event.getX();
     float y=event.getY();
     if (x>=width-50  &&  y>=20){
         index=(int) ((y-100)/every);
         if (index>=zimu.length){
             index=zimu.length-1;
         }
         invalidate();
         return true;
     }

        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }
}
