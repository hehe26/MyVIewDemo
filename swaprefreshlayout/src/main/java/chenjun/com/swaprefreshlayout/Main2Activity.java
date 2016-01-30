package chenjun.com.swaprefreshlayout;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import chenjun.com.swaprefreshlayout.view.CircleImageView;
import chenjun.com.swaprefreshlayout.view.ProgressDrawable;
import chenjun.com.swaprefreshlayout.view.SourceDrawable;

public class Main2Activity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.iv);
        circleImageView.setBackground(new ProgressDrawable(Color.RED));
       circleImageView.setImageDrawable(new SourceDrawable(Color.GREEN));
    }
}
