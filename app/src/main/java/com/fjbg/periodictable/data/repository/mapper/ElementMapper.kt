package com.fjbg.periodictable.data.repository.mapper

import com.fjbg.periodictable.data.local.ElementEntity
import com.fjbg.periodictable.data.remote.ElementResponse
import com.fjbg.periodictable.data.repository.Element

fun elementEntityToModel(entity: ElementEntity): Element =
	Element(
		id = entity.id,
		name = entity.name,
		symbol = entity.symbol,
	)

fun elementResponseToEntity(response: ElementResponse): ElementEntity =
	ElementEntity(
		id = 0,
		name = response.name,
		symbol = response.symbol,
	)

fun elementEntitiesToModels(entities: List<ElementEntity>): List<Element> =
	entities.map(::elementEntityToModel)

fun elementResponseToEntities(response: List<ElementResponse>): List<ElementEntity> =
	response.map(::elementResponseToEntity)

