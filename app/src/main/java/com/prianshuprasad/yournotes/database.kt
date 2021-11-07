package com.prianshuprasad.yournotes

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//import org.junit.runner.manipulation.Ordering
import  android.content.Context
//import notedao
//import notes


@Database(entities = arrayOf(notes::class),version = 1,exportSchema = false   )
public abstract class database : RoomDatabase(){

    abstract fun notesDao(): notedao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: database? = null

        fun getDatabase(context: Context): database {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    database::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }




}