package com.example.wekaradwan.blood.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by weka radwan on 2/22/2019.
 */

// Dao :- Data Access Object
// This is the operation that we will doing it on the DB
@Dao
public interface PeopleDao {

    // Ctrl+B will give you full info .

    // All of this method dose not Return anything so we make it void

    @Insert
    void insertPeople(PeopleEntity poepleEntity);

    @Update
    void updatePeople(PeopleEntity poepleEntity);

    @Delete
    void delete(PeopleEntity poepleEntity);

    @Query("DELETE FROM people_table")
    void deleteAllPeople();

    // This will display all table entity and it's return type as List of date and we but them in LiveData
    @Query("SELECT * FROM people_table Order By peopleAge ASC  ")
    LiveData<List<PeopleEntity>> getAllPeople();


    @Query("SELECT * FROM people_table WHERE blood_kind = :value")
     LiveData<List<PeopleEntity>> getPeopleWithBloodKind(String value);
}

