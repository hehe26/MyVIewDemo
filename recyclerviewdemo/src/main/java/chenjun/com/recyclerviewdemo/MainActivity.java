package chenjun.com.recyclerviewdemo;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import chenjun.com.recyclerviewdemo.decoration.HorizontalDivider;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> list = new ArrayList<String>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        initDatas();
        //recyclerView.setHasFixedSize(true);
        LinearLayoutManager lm =new LinearLayoutManager(this);
        //lm.se
        recyclerView.setLayoutManager(lm);
        recyclerView.addItemDecoration(new HorizontalDivider(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new MyAdapter());

    }

    private void initDatas() {
        for (int i=0;i<30;i++){
            list.add("hello 这是第"+i+"条数据");
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(MainActivity.this).inflate(R.layout.item_layout,parent,false);
            MyViewHolder viewHolder = new MyViewHolder(view);
           Log.d("test","onCreateViewHolder:viewHolder"+viewHolder);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {//缓存 是最多显示数+2
            Log.d("test","onBindViewHolder:holder"+holder+"    position="+position);

            holder.tv.setText(list.get(position));
            if(position==0){
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"position"+position,Toast.LENGTH_LONG).show();
//                        list.add(position,"hahaha");
//                        MyAdapter.this.notifyItemInserted(position);
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;


        public MyViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.tv);
        }
    }


}
