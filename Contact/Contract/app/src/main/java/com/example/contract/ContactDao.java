package com.example.contract;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDao {
    @Query("SELECT * FROM Contact")
    List<Contact> getAll();

    @Insert()
    void insert(Contact contact);

    @Query("SELECT * FROM Contact WHERE name LIKE '%' || :name || '%'")
    List<Contact> search(String name);

}
