package com.fjbg.periodictable.di

import android.content.Context
import androidx.room.Room
import com.fjbg.periodictable.data.PeriodicTableDatabase
import com.fjbg.periodictable.data.local.ElementDao
import com.fjbg.periodictable.utils.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DbModule {
	
	@Provides
	fun provideDatabase(@ApplicationContext context: Context): PeriodicTableDatabase =
		Room.databaseBuilder(
			context,
			PeriodicTableDatabase::class.java,
			DB_NAME
		).build()
	
	@Provides
	fun provideElementDao(database: PeriodicTableDatabase): ElementDao = database.elementDao()
}