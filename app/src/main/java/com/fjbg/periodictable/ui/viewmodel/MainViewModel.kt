package com.fjbg.periodictable.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.periodictable.data.repository.Element
import com.fjbg.periodictable.data.repository.ElementRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
	private val repository: ElementRepositoryImp
) : ViewModel() {
	
	val elementList = MutableStateFlow<List<Element>>(emptyList())
	
	init {
		viewModelScope.launch {
			repository.getElements().collect {
				elementList.value = it
			}
		}
	}
}