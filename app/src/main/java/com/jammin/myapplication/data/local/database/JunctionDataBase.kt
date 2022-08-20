package com.jammin.myapplication.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jammin.myapplication.data.local.dao.JunctionDao
import com.jammin.myapplication.data.local.entity.EmptyEntity

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
