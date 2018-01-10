package com.example.lad.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String[] charactersDC = {"Apple","Banana","Cherry","Grapes","Watermelon","Mango","Orange","Guava","Coconut","Strawberry","Pineapple","Raspberry","Kivi","Custerd Apple","Blackberry","Jackfruit","Peach","Pear","Pomegranate","Tamarind"};

    Button next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.List1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,charactersDC);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,int i,long l){
                Toast.makeText(getApplicationContext(),"Item Clicked : " + i ,Toast.LENGTH_SHORT).show();
            }
        });

        next1 = (Button)findViewById(R.id.btn_next1);
        next1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent page2 = new Intent(MainActivity.this,Main2Activity.class);

                startActivity(page2);
            }
        });


    }
}
