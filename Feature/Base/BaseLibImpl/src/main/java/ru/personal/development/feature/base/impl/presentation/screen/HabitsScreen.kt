package ru.personal.development.feature.base.impl.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.personal.development.feature.base.impl.data.Habit
import ru.personal.development.feature.base.impl.presentation.HabitsUiState
import ru.personal.development.feature.base.impl.presentation.HabitsViewModel
import ru.personal.development.feature.base.impl.presentation.ui.theme.Habits2Theme
import ru.personal.development.feature.base.impl.utils.HabitsUtils

@Composable
fun HabitsScreen(viewModel: HabitsViewModel) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    when (val state = uiState.value) {
        HabitsUiState.Loading -> {
            HabitsProgressBar()
        }

        is HabitsUiState.Success -> {
            HabitItems(habits = (state.habits))
        }
    }
}

@Composable
private fun HabitsProgressBar() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun HabitItems(habits: List<Habit>) {
    LazyColumn {
        items(habits) { habit ->
            HabitItem(habit = habit)
        }
    }
}

@Composable
private fun HabitItem(habit: Habit) {
    Column {
        Text(text = habit.name)
        Text(text = habit.description)
        Icon(imageVector = Icons.Default.Info, contentDescription = null)
    }
}


@Preview
@Composable
private fun HabitItemsPreview() {
    val habits = HabitsUtils.createHabits()
    Surface {
        Habits2Theme {
            HabitItems(habits = habits)
        }
    }
}

@Preview
@Composable
private fun HabitItemPreview() {
    val habit = HabitsUtils.createHabit()
    Surface {
        Habits2Theme {
            HabitItem(habit = habit)
        }
    }
}

@Preview
@Composable
private fun HabitsProgressBarPreview() {
    Surface {
        Habits2Theme {
            HabitsProgressBar()
        }
    }
}