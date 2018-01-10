package com.example.lad.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

public class Main3Activity extends AppCompatActivity {

    GridView gridView;
    String[] data = {"data1","data2","data3","data4","data5","data6","data7","data8","data9","data10","data11","data12",};
    Button prev3,next3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        prev3 = (Button)findViewById(R.id.btn_prev3);
        prev3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent page2 = new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(page2);
            }
        });

        next3 = (Button)findViewById(R.id.btn_next3);
        next3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent page4 = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(page4);
            }
        });

        gridView = (GridView)findViewById(R.id.List3);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        gridView.setAdapter(adapter);
    }
}
