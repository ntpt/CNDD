package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvCount;
    private FloatingActionButton btnAdd;
    private FloatingActionButton btnSub;
    private MyViewModel model;
    private ListView lvCount;
    private ArrayList<Integer> arrayList;
    private ArrayAdapter<Integer> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //model = new ViewModelProvider(this).get(MyViewModel.class);
        tvCount = findViewById(R.id.tv_count);
        btnAdd = findViewById((R.id.btn_add));

        lvCount = findViewById(R.id.lv_count);
        arrayList = new ArrayList<Integer>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        lvCount.setAdapter(arrayAdapter);

       /* model.getNumbers().observe( this, new Observer<Integer>(){
            @Override
            public void onChanged(Integer integer){
                tvCount.setText("" + integer);
                arrayList.add(integer);
                arrayAdapter.notifyDataSetChanged();
            }

                });*/

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(tvCount.getText().toString());
                tvCount.setText(""+ ++count);
                arrayList.add(count);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        btnSub = findViewById((R.id.btn_sub));

       lvCount.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
               arrayList.remove(position);
               arrayAdapter.notifyDataSetChanged();
               return false;
           }
       });

       lvCount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra( "number", arrayList.get(position).toString());
                startActivity(intent);
           }
       });


    }
}