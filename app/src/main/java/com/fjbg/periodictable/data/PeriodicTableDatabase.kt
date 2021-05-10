package com.fjbg.periodictable.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fjbg.periodictable.data.local.ElementDao
import com.fjbg.periodictable.data.local.ElementEntity

@Database(entities = [ElementEntity::class], version = 1, exportSchema = false)
abstract class PeriodicTableDatabase : RoomDatabase() {
	abstract fun elementDao(): ElementDao
}