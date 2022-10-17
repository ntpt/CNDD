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
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = (EditText) findViewById(R.id.et_num1);
        number2 = (EditText) findViewById(R.id.et_num2);
        equal = (Button) findViewById(R.id.btn_equal);
        arrayList = new ArrayList<String>();
        result = (ListView) findViewById((R.id.lvAnswer));
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        result.setAdapter(arrayAdapter);

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast toast = new Toast(getApplicationContext());
//                try{
//
//                    float num1 = Float.parseFloat(number1.getText().toString());
//                    float num2 = Float.parseFloat(number2.getText().toString());
//                    float div = num1/num2;
//                    arrayList.add(div);
//                    arrayAdapter.notifyDataSetChanged();
//                }
//                catch (RuntimeException e){
//                    toast.makeText(getBaseContext(), "Input field is empty", toast.LENGTH_SHORT).show();
//                }




                Toast toast = new Toast(getApplicationContext());
                if(number1.getText().toString().isEmpty() || number2.getText().toString().isEmpty() ){
                    toast.makeText(getBaseContext(), "Input field is empty", toast.LENGTH_SHORT).show();
                }
                else {
                    if (number1.getText().toString().matches("[a-zA-Z]+") ||
                            number2.getText().toString().matches("[a-zA-Z]+")) {
                        toast.makeText(getBaseContext(), "input cannot be text", toast.LENGTH_SHORT).show();
                    } else {
                        float num1 = Float.parseFloat(number1.getText().toString());
                        float num2 = Float.parseFloat(number2.getText().toString());
                        float div = num1 / num2;
                        arrayList.add(num1 + "/" + num2 + "=" +div);
                        arrayAdapter.notifyDataSetChanged();
                    }
                }


            }
        });
    }


}