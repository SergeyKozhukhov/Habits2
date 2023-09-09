package ru.personal.development.feature.base.impl.presentation

import ru.personal.development.feature.base.impl.data.Habit

sealed interface HabitsUiState {
    object Loading : HabitsUiState
    data class Success(val habits: List<Habit>) : HabitsUiState
    data class Error(val message: String)
}
