package com.fjbg.periodictable.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fjbg.periodictable.data.repository.Element
import com.fjbg.periodictable.ui.viewmodel.MainViewModel

@ExperimentalFoundationApi
@Composable
fun MainView(
	viewModel: MainViewModel
) {
	Box(
		Modifier
			.fillMaxSize()
			.padding(
				top = 48.dp,
				bottom = 24.dp,
				start = 24.dp,
				end = 24.dp
			)
	) {
		viewModel.elementList.observeAsState().value.let { list ->
			list?.let {
				ElementTable(it)
			}
		}
	}
}

@ExperimentalFoundationApi
@Composable
fun ElementTable(list: List<Element>) {
	
	LazyVerticalGrid(
		modifier = Modifier.fillMaxSize(),
		cells = GridCells.Fixed(18)
	) {
		items(
			count = list.size,
			itemContent = {
				Column(
					modifier = Modifier
						.padding(2.dp)
						.clickable {
						
						}
				) {
					if (list[it].name != null) {
						ElementContent(element = list[it])
					} else {
						EmptyElement()
					}
				}
			}
		)
	}
}

@Composable
fun ElementContent(element: Element) {
	Column(
		modifier = Modifier
			.background(Color.DarkGray)
			.fillMaxSize(20f)
	) {
		Text(
			textAlign = TextAlign.Center,
			color = Color.White,
			text = element.symbol ?: "",
			fontSize = 18.sp,
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 1.dp, bottom = 5.dp, start = 4.dp, end = 4.dp)
		)
		Text(
			text = element.name ?: "",
			fontSize = 10.sp,
			color = Color.White,
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 1.dp, bottom = 1.dp, start = 2.dp, end = 2.dp)
		)
	}
}

@Composable
fun EmptyElement() {
	Text(
		text = "",
		modifier = Modifier
			.fillMaxSize()
			.background(Color.Transparent)
	)
}