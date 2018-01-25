package com.example.musfiqrahman.waitlist;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by t00053669 on 1/25/2018.
 */

@Dao
public interface GuestDao {

    @Insert
    void insert(GuestInfo guest);

    @Delete
    void delete(GuestInfo guest);

    @Query("SELECT * FROM Guest ORDER BY guest ASC")
    LiveData<List<GuestInfo>> getAll();

    @Update
    void update(GuestInfo guest);

}


