package ru.personal.development.feature.base.impl.data

import ru.personal.development.feature.base.impl.utils.HabitsUtils

class HabitsRepository {

    fun getHabits(): List<Habit> = HabitsUtils.createHabits()
}