package com.bobby.cloner.core.domain.model

enum class Days(val daysInt: Int, val daysString: String) {
    MONDAY(0, "Monday"),
    TUESDAY(1, "Tuesday"),
    WEDNESDAY(2, "Wednesday"),
    THURSDAY(3, "Thursday"),
    FRIDAY(4, "Friday"),
    SATURDAY(5, "Saturday"),
    SUNDAY(6, "Sunday");

    companion object {
        fun getDayInString(daysInt: Int): String =
            values().find { it.daysInt == daysInt }?.daysString.orEmpty()
    }
}
