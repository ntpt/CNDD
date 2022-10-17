package com.example.contract;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class AddUser extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextEmail;
    private Button submitBtn;
    private AppDatabase db;
    private ContactDao contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_user);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        submitBtn = (Button) findViewById(R.id.submitBtn);

        db = AppDatabase.getInstance(this);
        contactDao = db.contactDao();


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactDao.insert(new Contact(editTextName.getText().toString(), editTextEmail.getText().toString()));
                startActivity(new Intent(AddUser.this, MainActivity.class));
            }
        });




    }
}