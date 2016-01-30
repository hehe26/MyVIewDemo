package chenjun.com.myviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    LinearLayout ll2;
    TextView tv;
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
        tv= (TextView) findViewById(R.id.tv);
    }

    public void click1(View view) {
        float alpha = ll2.getAlpha();
        //Toast.makeText(this,"alpha------"+alpha,Toast.LENGTH_LONG).show();
       // ll2.scrollTo(x,0);
        tv.scrollTo(0,x);
        Toast.makeText(this,"tv.getx------"+tv.getScrollY(),Toast.LENGTH_LONG).show();
        x=x+5;
    }
}
