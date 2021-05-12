package com.fjbg.periodictable.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
				top = 48.dp, bottom = 24.dp, start = 24.dp, end = 24.dp
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
					Text(
						textAlign = TextAlign.Center,
						color = Color.White,
						text = list[it].symbol ?: "",
						fontSize = 16.sp,
						modifier = Modifier
							.fillMaxSize()
							.clip(RoundedCornerShape(4.dp))
							.background(Color.DarkGray)
							.padding(top = 2.dp, bottom = 2.dp, start = 4.dp, end = 4.dp)
					)
				}
			}
		)
	}
}