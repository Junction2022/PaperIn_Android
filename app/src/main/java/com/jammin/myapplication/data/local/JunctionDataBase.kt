package com.jammin.myapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [
        EmptyEntity::class
    ],
    version = 1
)

@TypeConverters()

abstract class JunctionDataBase : RoomDatabase() {
    abstract fun junctionDao(): JunctionDao
}
