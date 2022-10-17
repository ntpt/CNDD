package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView tvDetail;
    private TextView editText;

    private Button btnEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        editText = findViewById(R.id.edit_text);
        tvDetail = findViewById(R.id.tv_detail);
        Intent receivedIntent = getIntent();

        if(receivedIntent !=null){
            String data = receivedIntent.getStringExtra( "number");
            tvDetail.setText(data);
            editText.setText(data);
        }

        btnEdit = findViewById(R.id.btn_edit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String numb = editText.getText().toString();
                tvDetail.setText(numb);
            }
        });


    }
}