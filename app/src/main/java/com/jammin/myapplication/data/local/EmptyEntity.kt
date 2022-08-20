package com.jammin.myapplication.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EmptyEntity(
    @PrimaryKey(autoGenerate = true) val key: Int = 0
)
