package com.prianshuprasad.yournotes

import androidx.lifecycle.LiveData
import androidx.room.*
//import notes

@Dao
interface notedao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note:notes)
    @Delete
    suspend fun delete(note: notes)

    @Query("Select * from notes_table order by id ASC")
     fun getAll(): LiveData<List<notes>>


}