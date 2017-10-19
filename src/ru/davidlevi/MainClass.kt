package ru.davidlevi

import java.lang.Math.sin

/**
 * Учим Kotlin
 */

/* Точка входа */
fun main(args: Array<String>) {
    if (args.isEmpty())
        return

    /* Цикл foreach 1 */
    for (arg in args)
        print(arg + " ")
    println()

    /* Цикл foreach 2 */
    args.forEach { arg -> print("$arg ") }
    println()

    /* Цикл for */
    for (index in args.indices)
        print(args[index] + " ")
    println()

    /* Цикл while */
    var index = 0
    while (index < args.size)
        print(args[index++] + " ")
    println()

    /* val - неизменяемая строковая переменная */
    val text: String = args[args.size - 1]

    /* Работа со строками */
    println("Последний аргумент: $text" + " или так " + text)

    /* Переменная может иметь значение null */
    val canBeNull: String? = null

    /* Тип `Long` */
    val a: Long = 1000

    /* Тип `Float` выведен автоматически */
    val b = 1.02f

    /* val - неизменяемая переменная */
    val d: String = "константа"

    /* Явное преобразование в Int */
    var e: Int = a.toInt()

    /* Функция */
    switch(1)
    switch("Hello")
    switch(1L)
    switch('1')

    /* Функция возвращающая значения */
    println(charToInt('2'))

    /* Создаем массив приметивного типа byte */
    val asc0: ByteArray = byteArrayOf(1, 2, 3, 4, 5)
    asc0[0] = (asc0[1] + asc0[2]).toByte()

    /* Создает массив Интов размера 5 */
    val asc1 = arrayOfNulls<Int>(5)

    /* Создает массив Интов */
    val asc2 = arrayOf(1, 2, 3, 4, 5)

    /* Создаёт массив типа Array<String> со значениями ["0", "1", "4", "9", "16"] размера 5 */
    val asc3 = Array(5) { i -> (i * i).toString() }

    /* Строка */
    val string = "Hello, world!\n"
    for (oneChar: Char in string)
        print("-${oneChar}")

    /* Строковые шаблоны */
    val ten = "10"
    println("i = $ten") // $ - начало шаблона
    println("length = ${ten.length}") // ${} - начало шаблона для выражения
    val price = 9.99f
    println("${'$'}$price") // ополнительный символ

    /* Логика */
    val q: Boolean = if (true == true) {
        true
    } else {
        false
    }
    println(q)

    /* Импорт функции из java.lang.Math.sin */
    println(sin(1.0))

    /* Создание экземпляров классов */
    val person = Person("David Levi", 35, "gDavidLevy@gmail.com", null, 100000.00f)
    val employer = Employer(person, "LLC Gazprom energo")

    /* Работа с типами  */
    println(person)
    person.setSalary(100001.00f)
    println("Salary: ${person.getSalary()}")
    println("Office: ${employer.company}")
    person.publicAccess = "set access"
    println("get access and ${person.publicAccess}")


}

/**
 * - Выражение when - это умный аналог ru.davidlevi.switch
 * - Функция
 */
fun switch(obj: Any) {
    /* аналог ru.davidlevi.switch */
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> { // блок
            throw Exception("Что-то туд не даг")
        }
    }
}

/**
 * Функция возвращающая значения
 */
fun charToInt(c: Char): Int {
    /* Если с не из диапазона */
    if (c !in '0'..'9')
        throw IllegalArgumentException("Вне диапазона")
    /* Явные преобразования в число */
    return c.toInt() - '0'.toInt()
}
