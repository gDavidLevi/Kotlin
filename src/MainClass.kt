/**
 * Учим Kotlin
 */

/* Точка входа */
fun main(args: Array<String>) {
    if (args.isEmpty())
        return

    /* Цикл foreach */
    for (arg in args)
        print(arg + " ")
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
    println("Последний аргумент: ${text}" + " или так " + text)

    /* Тип `Long` */
    var a: Long = 1000

    /* Тип `Float` выведен автоматически */
    var b = 1.02f

    /* Тип обязателен, когда значение не инициализируется */
    var c: Int
    c = 1

    /* val - неизменяемая переменная */
    val d: String = "константа"

    /* Явное преобразование в Int */
    var i: Int = a.toInt()

    /* Функция */
    switch(1)
    switch("Hello")
    switch(1L)
    switch('1')

    println(charToInt('2'))

}

/**
 * - Выражение when - это умный аналог switch
 * - Функция
 */
fun switch(obj: Any) {
    /* аналог switch */
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