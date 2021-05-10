package com.fjbg.periodictable.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fjbg.periodictable.data.repository.Element
import com.fjbg.periodictable.ui.viewmodel.MainViewModel
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun MainView(
	viewModel: MainViewModel
) {
	Box(Modifier.fillMaxSize()) {
		viewModel.elementList.asStateFlow().value.let {
			ElementTable(list = it)
		}
	}
}

@Composable
fun ElementTable(list: List<Element>) {
	
	LazyColumn(Modifier.fillMaxSize()) {
		items(
			count = list.size,
			itemContent = {
				Text(text = "1")
			})
	}
}