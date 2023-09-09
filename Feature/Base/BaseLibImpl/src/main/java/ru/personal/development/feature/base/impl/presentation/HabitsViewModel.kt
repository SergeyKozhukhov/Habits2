package ru.personal.development.feature.base.impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.personal.development.feature.base.impl.data.HabitsRepository

class HabitsViewModel(private val repository: HabitsRepository) : ViewModel() {

    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow<HabitsUiState>(HabitsUiState.Loading)

    fun loadHabits() = viewModelScope.launch {
        delay(3000)
        _uiState.value = HabitsUiState.Success(repository.getHabits())
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun provide(repository: HabitsRepository) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return HabitsViewModel(repository) as T
            }
        }
    }
}