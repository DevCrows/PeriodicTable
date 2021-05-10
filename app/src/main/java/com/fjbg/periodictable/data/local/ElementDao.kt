package com.fjbg.periodictable.data.local

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ElementDao {
	
	@Query("SELECT * FROM element")
	fun getElements(): Flow<List<ElementEntity>>
	
	@Query("SELECT * FROM element WHERE id=:elementId")
	fun getElementById(elementId: Int): ElementEntity
	
	@Query("SELECT * FROM element WHERE name=:elementName")
	fun getElementByName(elementName: String): ElementEntity
}