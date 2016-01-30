package chenjun.com.myviewdemo;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyViewPager viewPager;
    private ArrayList<View> list = new ArrayList<View>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        viewPager= (MyViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(new MyAdapter());
        SlidingMenu slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);

        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //slidingMenu.setTouchModeBehind(SlidingMenu.TOUCHMODE_MARGIN);

        //slidingMenu.setBehindWidthRes(R.dimen.slidingmenu_offset);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);

//        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
//        slidingMenu.setShadowDrawable(R.mipmap.ic_launcher);

        slidingMenu.setBehindScrollScale(0.5f);

        //slidingMenu.setFadeDegree(0.35f);

        slidingMenu.setOnOpenListener(new SlidingMenu.OnOpenListener() {
            @Override
            public void onOpen() {
                Toast.makeText(MainActivity.this,"onOpen",Toast.LENGTH_LONG).show();
            }
        });
        slidingMenu.setOnCloseListener(new SlidingMenu.OnCloseListener() {
            @Override
            public void onClose() {
                Toast.makeText(MainActivity.this,"onClose",Toast.LENGTH_LONG).show();
            }
        });

        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);

        slidingMenu.setMenu(R.layout.left_menu_layout);
    }

    private void initDatas() {
        ImageView iv1 = new ImageView(this);
        ImageView iv2 = new ImageView(this);
        ImageView iv3 = new ImageView(this);
       // iv2.setClickable(true);

        iv1.setImageResource(R.mipmap.account_icon_kaixin);
        iv2.setImageResource(R.mipmap.account_icon_mobile);
        iv3.setImageResource(R.mipmap.account_icon_qzone);
        list.add(iv1);
        list.add(iv2);
        list.add(iv3);


    }

    //public void click(View view){
//        startActivity(new Intent(this,Main2Activity.class));
//    }
    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = list.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView(list.get(position));
        }

    }
}
