package com.fjbg.periodictable.data.remote.endpoint

import com.fjbg.periodictable.data.remote.ElementWrapper
import retrofit2.http.GET

interface ElementApi {
	
	@GET("/DevCrows/Periodic-Table-JSON/master/formatted.json")
	suspend fun getElements(): ElementWrapper
}