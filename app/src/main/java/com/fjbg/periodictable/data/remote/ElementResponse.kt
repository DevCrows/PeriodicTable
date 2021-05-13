package com.fjbg.periodictable.data.remote

data class ElementResponse(
	val name: String?,
	val symbol: String?
)

data class ElementWrapper(
	val elements: List<ElementResponse>
)