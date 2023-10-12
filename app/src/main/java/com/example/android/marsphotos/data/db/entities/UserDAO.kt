package com.example.android.marsphotos.data.db.entities

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User) :String

    @Query("SELECT * FROM user where member_id = 1 ")
    fun getuser() :LiveData<User>
}