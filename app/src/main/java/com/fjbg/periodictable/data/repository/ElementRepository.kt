package com.fjbg.periodictable.data.repository

import kotlinx.coroutines.flow.Flow

interface ElementRepository {
	suspend fun getElements(): Flow<List<Element>>
	suspend fun getElementById(elementId: Int): Element
}