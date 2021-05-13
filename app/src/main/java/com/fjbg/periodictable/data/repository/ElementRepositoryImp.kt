package com.fjbg.periodictable.data.repository

import com.fjbg.periodictable.data.PeriodicTableDatabase
import com.fjbg.periodictable.data.remote.ElementResponse
import com.fjbg.periodictable.data.remote.endpoint.ElementApi
import com.fjbg.periodictable.data.repository.mapper.elementEntitiesToModels
import com.fjbg.periodictable.data.repository.mapper.elementEntityToModel
import com.fjbg.periodictable.data.repository.mapper.elementResponseToEntities
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class ElementRepositoryImp @Inject constructor(
	private val database: PeriodicTableDatabase,
	private val elementApi: ElementApi,
) : ElementRepository {
	
	override suspend fun getElements(): Flow<List<Element>> {
		
		database.elementDao().deleteElements()
		
		val elementResponse = getElementsRemote()
		saveElements(elementResponse)
		return database.elementDao().getElements().map {
			elementEntitiesToModels(it)
		}
	}
	
	override suspend fun getElementsRemote(): List<ElementResponse> {
		return elementApi.getElements().elements
	}
	
	override suspend fun saveElements(list: List<ElementResponse>) {
		val elementEntities = elementResponseToEntities(list)
		GlobalScope.launch {
			database.elementDao().insertElement(elementEntities)
		}
	}
	
	override suspend fun getElementById(elementId: Int): Element =
		elementEntityToModel(database.elementDao().getElementById(elementId))
	
	init {
		GlobalScope.launch {
			getElementsRemote()
		}
		
	}
	
}