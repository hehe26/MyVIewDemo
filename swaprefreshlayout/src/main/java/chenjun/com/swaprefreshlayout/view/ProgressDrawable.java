package chenjun.com.swaprefreshlayout.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Created by chenjun on 16-1-27.
 */
public class ProgressDrawable extends Drawable {
    private Paint paint;
    public ProgressDrawable(int color){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
    }

    @Override
    public void draw(Canvas canvas) {
        Rect rect = getBounds();
        float centerX = rect.exactCenterX();
        float centerY = rect.exactCenterY();
        canvas.drawCircle(centerX,centerY,Math.min(centerX,centerY),paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
