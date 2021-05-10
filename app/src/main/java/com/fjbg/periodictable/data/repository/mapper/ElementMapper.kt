package com.fjbg.periodictable.data.repository.mapper

import com.fjbg.periodictable.data.local.ElementEntity
import com.fjbg.periodictable.data.remote.ElementResponse
import com.fjbg.periodictable.data.repository.Element

fun elementModelToEntity(model: Element): ElementEntity =
	ElementEntity(
		id = model.id,
		name = model.name,
	)

fun elementEntityToModel(entity: ElementEntity): Element =
	Element(
		id = entity.id,
		name = entity.name,
	)

fun elementResponseToEntity(response: ElementResponse): ElementEntity =
	ElementEntity(
		id = response.id,
		name = response.name,
	)