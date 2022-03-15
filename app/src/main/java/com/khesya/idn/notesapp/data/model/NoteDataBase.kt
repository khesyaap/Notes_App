package com.khesya.idn.notesapp.data.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [NoteData::class], version = 1, exportSchema = false)
@TypeConverters(Converter:: class)
abstract class NoteDatabase :RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object{
        @Volatile
        private var INSTANCE : NoteDatabase? = null
        fun getDatabase(context: Context) : NoteDatabase{
            val tempInstance = Companion.INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}