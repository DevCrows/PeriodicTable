package com.fjbg.periodictable.data.repository

import com.fjbg.periodictable.data.remote.ElementResponse
import kotlinx.coroutines.flow.Flow

interface ElementRepository {
	suspend fun getElements(): Flow<List<Element>>
	suspend fun getElementsRemote(): List<ElementResponse>
	suspend fun saveElements(list: List<ElementResponse>)
	suspend fun getElementById(elementId: Int): Element
}