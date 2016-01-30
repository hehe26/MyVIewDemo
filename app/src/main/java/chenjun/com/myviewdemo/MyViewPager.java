package chenjun.com.myviewdemo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * Created by chenjun on 16-1-30.
 */
public class MyViewPager extends ViewPager {
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int currentItem = getCurrentItem();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
            //    Toast.makeText(getContext(),"currentItem"+currentItem,Toast.LENGTH_LONG).show();
               Log.d("test","ACTION_DOWN");
                if(currentItem!=0){
                    requestDisallowInterceptTouchEvent(true);

                }
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("test", "ACTION_MOVE");
               //Toast.makeText(getContext(),"currentItem"+currentItem,Toast.LENGTH_LONG).show();

                break;

            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return super.onTouchEvent(ev);
    }
}
