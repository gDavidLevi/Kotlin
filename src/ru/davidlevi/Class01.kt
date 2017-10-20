// имя файла: Class01.kt
package ru.davidlevi

class Class01(person: Person, company: String) : Employer(person, company) {
    /* Уже здесь невозможно переопределить (override) метод setID из Employer потому, что он с final override */

    companion object { // называется ".Companion."
        fun create(): String = "created"
    }

    object Singleton {
        lateinit var string: String
    }

    /* Расширения для класса C */
    fun other() {
        val instance1 = Class01.create()           // вызов из companion object
        val instance2 = Class01.Companion.create() // вызов из companion object
    }
}

/**
 * Расширения вспомогательных объектов (ориг.: companion object extensions)
 */
fun Class01.Companion.foo() {
    // Код расширения для класса OtherNewClass
}

/**
 * Будем расширять класс Class02 методом other() из класса Class01
 */
class Class02 {
    fun my() {}

    /* Метод foo() будер расширяться методами класса Class01 */
    fun Class01.foo() {
        other()   // вызывает Class01.other
        my()      // вызывает Class02.my
        toString()               // вызывает Class01.toString()
        this@Class02.toString()  // Явное указание! вызывает Class02.toString()
    }

    fun caller(otherNewClass: Class01) {
        otherNewClass.foo()   // вызов функции-расширения
    }
}
