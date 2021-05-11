package com.fjbg.periodictable.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import com.fjbg.periodictable.ui.theme.PeriodicTableTheme
import com.fjbg.periodictable.ui.view.MainView
import com.fjbg.periodictable.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	
	val viewModel: MainViewModel by viewModels()
	
	@ExperimentalFoundationApi
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
			or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
		window.statusBarColor = Color.TRANSPARENT
		
		setContent {
			PeriodicTableTheme {
				MainView(viewModel)
			}
		}
	}
}