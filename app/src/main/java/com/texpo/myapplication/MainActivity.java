package com.texpo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> listData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listData = new ArrayList<DataModel>();
        ListView lview = (ListView) findViewById(R.id.listview);
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "The position is:" + i, Toast.LENGTH_SHORT).show();
            }
        });
        final ListAdapter adapter = new ListAdapter(this, listData);
        lview.setAdapter(adapter);

        populateList();
        Button btn = (Button) findViewById(R.id.btnAdd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listData.add( new DataModel("", "", "", ""));
                adapter.notifyDataSetChanged();
            }
        });
        adapter.notifyDataSetChanged();


    }

    private void populateList() {

        DataModel item1, item2, item3, item4, item5;

        item1 = new DataModel("", "", "", "");
        listData.add(item1);

        item2 = new DataModel("", " ", "", "");
        listData.add(item2);

    }
}