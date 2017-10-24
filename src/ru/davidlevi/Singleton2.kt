package ru.davidlevi

/**
 * Класс-синглтон с использованием паттерна «ленивая загрузка»
 */
class Singleton2 private constructor() { // Приватный конструктор используется для того, чтобы гарантировать, что объект данного класса будет создан только внутри этого класса

    /* Метод init будет вызван при загрузке данного класса, т. е. при первом вызове Singleton.instance */
    init {
        println("Это ($this) и есть синглтон.")
    }

    /* Holder object & lazy instance используются для создания единственного экземпляра класса */
    private object Holder {
        val INSTANCE = Singleton2()
    }

    companion object {
        val instance: Singleton2 by lazy { Holder.INSTANCE } // Ленивое свойства (триггер обращения к полю)
    }

    var b: String? = null
}