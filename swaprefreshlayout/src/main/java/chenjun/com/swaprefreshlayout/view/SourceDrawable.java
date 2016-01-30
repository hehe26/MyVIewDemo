package chenjun.com.swaprefreshlayout.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Created by chenjun on 16-1-27.
 */
public class SourceDrawable extends Drawable {
    private Paint mPaint;
    public SourceDrawable(int color){
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth((float)3.0);
        mPaint.setColor(color);
    }
    @Override
    public void draw(Canvas canvas) {
        Rect rect = getBounds();
        float centerX = rect.exactCenterX();
        float centerY = rect.exactCenterY();
        canvas.drawCircle(centerX,centerY,Math.min(centerX/2,centerY/2),mPaint);

    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
