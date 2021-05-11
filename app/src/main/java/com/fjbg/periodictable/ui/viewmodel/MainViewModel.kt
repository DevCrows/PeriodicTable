package com.fjbg.periodictable.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjbg.periodictable.data.repository.Element
import com.fjbg.periodictable.data.repository.ElementRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
	private val repository: ElementRepositoryImp
) : ViewModel() {
	
	private val _elementList = MutableLiveData<List<Element>>()
	val elementList: LiveData<List<Element>> = _elementList
	
	init {
		viewModelScope.launch {
			repository.getElements().collect {
				val fakeList = arrayListOf<Element>()
				for (i in 1..162) {
					fakeList.add(
						Element(
							id = i,
							name = "He"
						)
					)
				}
				_elementList.value = fakeList
			}
		}
	}
}