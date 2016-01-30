package chenjun.com.recyclerviewdemo.decoration;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import chenjun.com.recyclerviewdemo.R;

/**
 * Created by chenjun on 16-1-24.
 */
public class HorizontalDivider extends RecyclerView.ItemDecoration {
    Drawable drawable;
    public HorizontalDivider(Context context){
        drawable=context.getResources().getDrawable(R.mipmap.horizontal_devider);
    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        Log.d("test", "onDraw");
        int childCount = parent.getChildCount();
        for (int i=0;i<childCount;i++){
            View view = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();

            drawable.setBounds(parent.getPaddingLeft(),view.getBottom()+params.bottomMargin,parent.getWidth()-parent.getPaddingRight(),
                                    view.getBottom()+params.bottomMargin+10);
            drawable.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        Log.d("test", "ogetItemOffsets");
        outRect.set(0, 0, 0, 10);
        //int left, int top, int right, int bottom   right-left  表示 item在x轴的偏移量   为正 像左偏移  bottom-top y轴偏移量  为正向下偏 反之向上
    }
}
