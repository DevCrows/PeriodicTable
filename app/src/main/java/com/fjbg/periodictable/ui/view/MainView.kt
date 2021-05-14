package com.fjbg.periodictable.ui.view

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fjbg.periodictable.data.repository.Element
import com.fjbg.periodictable.ui.viewmodel.MainViewModel
import com.fjbg.periodictable.utils.TAG

@ExperimentalFoundationApi
@Composable
fun MainView(
	viewModel: MainViewModel
) {
	Column(
		Modifier
			.fillMaxSize()
			.padding(
				top = 42.dp,
				bottom = 24.dp,
				start = 14.dp,
				end = 14.dp
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
	
	Column {
		LazyVerticalGrid(
			modifier = Modifier.fillMaxSize(),
			cells = GridCells.Fixed(18)
		) {
			items(
				count = list.size,
				itemContent = {
					Column(
						modifier = Modifier.padding(1.dp)
					) {
						for (i in 1..list.size) {
							Log.d(TAG, "ElementTable: $i")
						}
						if (list[it].name != null) {
							ElementContent(element = list[it])
						}
					}
				}
			)
		}
	}
}

@Composable
fun ElementContent(element: Element) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.border(
				0.5.dp,
				color = Color.DarkGray,
				shape = RectangleShape
			)
			.clickable {
				
			}
	) {
		Text(
			text = element.symbol ?: "",
			fontSize = 18.sp,
			textAlign = TextAlign.Center,
			color = Color.White,
			modifier = Modifier
				.background(Color.Black)
				.fillMaxWidth()
				.padding(top = 1.dp, bottom = 5.dp, start = 4.dp, end = 4.dp)
		)
		Text(
			overflow = TextOverflow.Ellipsis,
			text = element.name ?: "",
			fontSize = 8.sp,
			textAlign = TextAlign.Center,
			maxLines = 1,
			color = Color.White,
			modifier = Modifier
				.background(Color.Black)
				.fillMaxWidth()
				.padding(top = 1.dp, bottom = 1.dp, start = 2.dp, end = 2.dp)
		)
	}
}
