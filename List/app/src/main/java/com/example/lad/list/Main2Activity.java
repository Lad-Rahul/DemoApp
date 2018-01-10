package com.example.lad.list;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main2Activity extends AppCompatActivity{

    HashMap<String,List<String>> myHeader;
    List<String> myChild;
    ExpandableListView expList;
    MyAdapter adapter;
    Button prev2,next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        expList = (ExpandableListView) findViewById(R.id.List2);
        myHeader = MyAdapter.DataProvider.getInfo();
        myChild = new ArrayList<String>(myHeader.keySet());
        adapter = new MyAdapter(this,myHeader,myChild);
        expList.setAdapter(adapter);

        prev2 = (Button)findViewById(R.id.btn_prev2);
        prev2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent page1 = new Intent(Main2Activity.this,MainActivity.class);

                startActivity(page1);
            }
        });

        next2 = (Button)findViewById(R.id.btn_next2);
        next2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent page3 = new Intent(Main2Activity.this,Main3Activity.class);

                startActivity(page3);
            }
        });
    }
}

class MyAdapter extends BaseExpandableListAdapter {

    private Context ctx;
    private HashMap<String, List<String>> ChildTitles;
    private List<String> HeaderTitles;

    MyAdapter(Context ctx, HashMap<String, List<String>> ChildTitles, List<String> HeaderTitles) {
        this.ctx = ctx;
        this.ChildTitles = ChildTitles;
        this.HeaderTitles = HeaderTitles;
    }

    @Override
    public int getGroupCount() {
        return HeaderTitles.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return ChildTitles.get(HeaderTitles.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return HeaderTitles.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return ChildTitles.get(HeaderTitles.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) this.getGroup(i);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_header2, null);
        }

        TextView txt = (TextView) view.findViewById(R.id.txt_header);
        txt.setTypeface(null, Typeface.BOLD);
        txt.setText(title);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) this.getChild(i, i1);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_child2, null);
        }
        TextView txt = (TextView) view.findViewById(R.id.txt_child);
        txt.setText(title);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public static class DataProvider {

        public static HashMap<String, List<String>> getInfo() {

            HashMap<String, List<String>> HeaderDetails = new HashMap<String, List<String>>();

            List<String> ChildDetails1 = new ArrayList<String>();
            ChildDetails1.add("Apple");
            ChildDetails1.add("Banana");
            ChildDetails1.add("Mango");
            ChildDetails1.add("Berry");
            ChildDetails1.add("Watermelon");

            List<String> ChildDetails2 = new ArrayList<String>();
            ChildDetails2.add("Cycle");
            ChildDetails2.add("Bike");
            ChildDetails2.add("Car");
            ChildDetails2.add("Truck");
            ChildDetails2.add("tain");

            List<String> ChildDetails3 = new ArrayList<String>();
            ChildDetails3.add("tomato");
            ChildDetails3.add("Onion");
            ChildDetails3.add("Cabbage");
            ChildDetails3.add("Potato");
            ChildDetails3.add("Carrot");

            List<String> ChildDetails4 = new ArrayList<String>();
            ChildDetails4.add("Circle");
            ChildDetails4.add("Cube");
            ChildDetails4.add("Rectangle");
            ChildDetails4.add("Oval");
            ChildDetails4.add("Polygon");

            List<String> ChildDetails5 = new ArrayList<String>();
            ChildDetails5.add("Crane");
            ChildDetails5.add("Crow");
            ChildDetails5.add("Sparrow");
            ChildDetails5.add("Dove");
            ChildDetails5.add("Eagle");

            HeaderDetails.put("Fruits", ChildDetails1);
            HeaderDetails.put("Vehicles", ChildDetails2);
            HeaderDetails.put("Vegetables", ChildDetails3);
            HeaderDetails.put("Shape", ChildDetails4);
            HeaderDetails.put("Birds", ChildDetails5);

            return HeaderDetails;
        }

    }

}

