package com.example.ktgk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private EditText number1;
    private TextView tv;
    private EditText number2;
    private Button equal;

    private ListView result;
    private ArrayList<Float> arrayList;
    private ArrayAdapter<Float> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = (EditText) findViewById(R.id.et_num1);
        number2 = (EditText) findViewById(R.id.et_num2);
        equal = (Button) findViewById(R.id.btn_equal);
        arrayList = new ArrayList<Float>();
        result = (ListView) findViewById((R.id.lvAnswer));
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        result.setAdapter(arrayAdapter);

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1 = Float.parseFloat(number1.getText().toString());
                float num2 = Float.parseFloat(number2.getText().toString());
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                if(number1.getText().toString()==null || number2.getText().toString()==null ){
                    toast.makeText(getBaseContext(), "Input field is empty", toast.LENGTH_SHORT).show();
                }else{
                     num1 = Float.parseFloat(number1.getText().toString());
                     num2 = Float.parseFloat(number2.getText().toString());
                }
                float div = num1/num2;
                arrayList.add(div);
                arrayAdapter.notifyDataSetChanged();

            }
        });
    }


}