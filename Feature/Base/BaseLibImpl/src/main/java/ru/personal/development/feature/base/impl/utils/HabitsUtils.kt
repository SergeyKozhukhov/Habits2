package ru.personal.development.feature.base.impl.utils

import ru.personal.development.feature.base.impl.data.Habit

object HabitsUtils {

    fun createHabits() = listOf(
        Habit(
            id = 0,
            name = "Бег",
            description = "Бегать каждое утро по 30 минут",
            date = 1693851389
        ),
        Habit(
            id = 0,
            name = "Пение",
            description = "Ходить в школу вокала три месяца",
            date = 1693526400
        )
    )

    fun createHabit() = Habit(
        id = 0,
        name = "Бег",
        description = "Бегать каждое утро по 30 минут",
        date = 1693851389
    )
}