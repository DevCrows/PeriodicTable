package com.fjbg.periodictable.data.repository

import com.fjbg.periodictable.data.PeriodicTableDatabase
import com.fjbg.periodictable.data.repository.mapper.elementEntitiesToModels
import com.fjbg.periodictable.data.repository.mapper.elementEntityToModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ElementRepositoryImp @Inject constructor(
	val database: PeriodicTableDatabase
) : ElementRepository {
	override suspend fun getElements(): Flow<List<Element>> =
		database.elementDao().getElements().map {
			elementEntitiesToModels(it)
		}
	
	override suspend fun getElementById(elementId: Int): Element =
		elementEntityToModel(database.elementDao().getElementById(elementId))
	
}