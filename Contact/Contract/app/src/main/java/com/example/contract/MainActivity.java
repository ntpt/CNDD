package com.example.contract;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mainView;
    private ContractAdapter adapter;
    private ArrayList<Contact> contacts;
    private AppDatabase db;
    private ContactDao contactDao;
    private FloatingActionButton addUserFab;
    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getInstance(this);
        contactDao = db.contactDao();
        contacts = new ArrayList<Contact>();

        addUserFab = (FloatingActionButton) findViewById(R.id.addNewUserFab);

        addUserFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddUser.class));
            }
        });

        searchBar = (EditText) findViewById(R.id.seachBar);
        contacts = (ArrayList<Contact>) contactDao.getAll();
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                contacts = (ArrayList<Contact>) contactDao.search(charSequence.toString());
                adapter = new ContractAdapter((ArrayList<Contact>) contacts);
                mainView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().trim().length() == 0) {
                    contacts = (ArrayList<Contact>) contactDao.getAll();
                    adapter = new ContractAdapter((ArrayList<Contact>) contacts);
                    mainView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

            }
        });

        mainView = (RecyclerView) findViewById(R.id.ContractView);
        mainView.setLayoutManager(new LinearLayoutManager(this));


        adapter = new ContractAdapter((ArrayList<Contact>) contacts);
        mainView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}