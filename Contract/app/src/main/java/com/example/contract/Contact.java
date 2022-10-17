package com.example.contract;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo
    private String name;

    @ColumnInfo
    private String email;


    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {this.email = email;}

    public  int getID() { return ID; }

    public void setID(int ID) {
        this.ID = ID;
    }
}