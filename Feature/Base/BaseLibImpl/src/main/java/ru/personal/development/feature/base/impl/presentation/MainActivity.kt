package ru.personal.development.feature.base.impl.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import ru.personal.development.feature.base.impl.data.HabitsRepository
import ru.personal.development.feature.base.impl.presentation.screen.HabitsScreen
import ru.personal.development.feature.base.impl.presentation.ui.theme.Habits2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(
            this,
            HabitsViewModel.provide(HabitsRepository())
        )[HabitsViewModel::class.java]

        viewModel.loadHabits()

        setContent {
            Habits2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HabitsScreen(viewModel = viewModel)
                }
            }
        }
    }
}