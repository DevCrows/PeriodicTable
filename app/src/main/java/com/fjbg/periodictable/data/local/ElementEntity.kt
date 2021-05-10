package com.fjbg.periodictable.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "element")
data class ElementEntity(
	@PrimaryKey(autoGenerate = true)
	val id: Int,
	val name: String,
)