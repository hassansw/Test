package com.texpo.myapplication;

import android.support.design.widget.BottomSheetBehavior;
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
    private BottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listData = new ArrayList<DataModel>();
        ListView lview = (ListView) findViewById(R.id.listview);

        View bottomSheet = findViewById( R.id.botSheet );
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setPeekHeight(0);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });

        lview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                return false;
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