package com.example.lad.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import static com.example.lad.list.R.id.search_bar;

public class Main4Activity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    ListView lv;
    SearchView sv;
    ArrayAdapter<String> adapter;
    private final String[] data = {"Apple","Banana","Mango","Watermelon","Raspberry","Chocolate","Cherry","Bus","Aeroplane","Computer","Camel","Cow","Buffalo","Ox","Tree","Root","Branch","Car","Bike","Train","Bullet Train","Maglev Train","Horse","Donkey","Elephant","Eraser","Pencil","Pen","Fish","Flower","Rose","Lotus","Lemon","Gate","Goat","Hat","Ice Cream","Ice","Jackfruit","Jacket","Kite","Monkey","Nose","Orange","Queen","Queue","List","Rat","Rock","Sample","Toy","Umbrella","Vanila","Water","X-mas Tree","Yark","Zebra"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_main4);

        sv = (SearchView)findViewById(R.id.search_bar);
        lv = (ListView)findViewById(R.id.List4);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);

        lv.setAdapter(adapter);
        lv.setTextFilterEnabled(true);
        setupSearchview();

    }

    public void setupSearchview() {
        sv.setIconifiedByDefault(false);
        sv.setOnQueryTextListener(this);
        sv.setSubmitButtonEnabled(true);
        sv.setQueryHint("Search Here");
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if(TextUtils.isEmpty(newText)){
            lv.clearTextFilter();
        }
        else{
            lv.setFilterText(newText.toString());
        }
        return true;
    }
}

