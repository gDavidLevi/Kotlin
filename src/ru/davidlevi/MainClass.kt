// имя файла: MainClass.kt
package ru.davidlevi

import java.io.File
import java.lang.Math.sin
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

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

    /* Функция-расширения swap */
    val array = mutableListOf(1, 2, 3) // изменяемый список (a la ArrayList)
    println(array)
    array.swap(0, 2)
    println(array)

    /* Класс данных data class... */
    val user1 = User("David", 35)
    println(user1)
    val user2: User
    user2 = user1.copy()
    println(user2)
    val user3: User
    user3 = user1.copy(age = 40) // с корректировкой поля age
    println(user3)

    /* Классы данных и мульти-декларации */
    val sarah = User("Sarah", 30)
    val (name, age) = sarah // поля класса раскидали по переменным
    println("$name, $age years of age")

    /* Функция возвращает два звачения */
    val df = Handler(11, 12)
    val (x1, x2) = df.funReturnsTwoResults(1)
    println("x1=$x1 x2=$x2")

    /* Анонимные объекты (ориг. Object expressions) */
    // пример 1. просто объект
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    print(adHoc.x + adHoc.y)
    // пример 2.
    open class A(x: Int) {
        public open val y: Int = x
    }

    val ab: A = object : A(1) {
        override val y = 15
    }
    // пример 3. Синглтон. Объявления объектов
    object {
        fun registerDataProvider(string: String) {
            // ...
        }
    }.registerDataProvider("data")
    println()

    /* Делегированные свойства */
    class Delegate { // делегат
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, спасибо за делегирование мне '${property.name}'!"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$value было присвоено значению '${property.name} в $thisRef.'")
        }
    }

    class AnExample {
        var p: String by Delegate() // привязываем делегата
    }

    val anExample = AnExample()
    // При обращении к делегируему свойству:
    println(anExample.p) // ru.davidlevi.MainClassKt$main$AnExample@5bcab519, спасибо за делегирование мне 'p'!
    anExample.p = "new"  // new было присвоено значению 'p в ru.davidlevi.MainClassKt$main$AnExample@5700d6b1.'

    /* Ленивые свойства (lazy properties) */
    val lazyValue1: String by lazy(LazyThreadSafetyMode.NONE) {
        // NONE - вычисления будут в одной нити (не быть потокобезопасный)
        println("computed!") // просто выведет в консоль
        "Hello" // эта строка присвоится переменной lazyValue
    }
    println(lazyValue1 + ", World!") // Hello, World!
    //
    val lazyValue2: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
        // PUBLICATION - вычисления будут возможны из разных нитей (потокобезопасный)
        println("lazy!")
        "Hello"
    }

    /* Observable свойства */
    class Worker {
        /*
        * prop - описание свойства, которое изменяется
        * old - старое значение
        * new - новое значение
        * -> - обработчик
        */
        var name: String by Delegates.observable("default") { prop, old, new -> println("$old -> $new") }

        // если нужно иметь возможность запретить присваивание некоторых значений
        var nameLockd: String by Delegates.vetoable("default") { prop, old, new -> (new != "123") }
    }

    val worker = Worker()
    worker.name = "первый"
    worker.name = "второй"
    worker.name = "третий"
    worker.nameLockd = "123"
    println(worker.nameLockd) // будет default потому что запрещено в лямбде new != "123"

    /* Хранение свойств в ассоциативном списке */
    // Это полезно в "динамическом" коде, например, при работе с JSON:
    class TheUser(val map: Map<String, Any?>) {
        val name: String by map
        val age: Int     by map
    }

    val theUser = TheUser(mapOf("name" to "John Doe", "age" to 25))

    println(theUser.name) // Prints "John Doe"
    println(theUser.age)  // Prints 25

    // Поддерживает изменяемые свойства
    class MutableUser(val map: MutableMap<String, Any?>) {
        var name: String by map
        var age: Int     by map
    }

    val theMutableUser = MutableUser(mutableMapOf("name" to "John Doe", "age" to 25))

    println(theMutableUser.name) // Prints "John Doe"
    println(theMutableUser.age)  // Prints 25

    /* Функции. Инфиксная запись */
    infix fun Int.mul2(time: Int): Int {
        return this shl time // shl = умножим на 2
    }
    println(2.mul2(3)) // 2 - this, 3 - аргумент; результат 16
    println(2 mul2 3)

    /* Функции. Аргументы по умолчанию */
    readMe(arrayOf(1, 2, 3, 4, 5))

    /* Функции. Как можно вызвать функцию с параметрами по умолчанию */
    reformat("str")
    reformat("str", true, true, false, '_')
    reformat("str", wordSeparator = ';')

    /* Нефиксированное число аргументов (Varargs) */
    val list1 = asList(1, 2, 3, 4, 5)
    println(list1) // [1, 2, 3, 4, 5]
    val arr = arrayOf(1, 2, 3)
    val list2 = asList(-1, 0, *arr, 4)  // * - spread (передать аргументы один-за-одним)
    println(list2) // [-1, 0, 1, 2, 3, 4]

    /* Функции анонимные, см. также инфиксную запись */
    val sum1 = fun Int.(other: Int): Int = this + other
    println(1.sum1(2))

    /* Singleton1 */
    val s1 = Singleton1    // Синглтон
    s1.info = "hello s1"
    // Если создать второй объект и прочитать значение поля b, то...
    val s2 = Singleton1
    //... получим то, что записали в первый объект (first)
    println(s2.info) // hello s1

    /* Singleton2 */
    val first = Singleton2.instance
    first.b = "hello w1"
    val second = Singleton2.instance
    println(second.b) // hello w1

    /* Коллекции */
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
    val readOnlyView: List<Int> = numbers
    println(numbers)        // выведет "[1, 2, 3]"
    numbers.add(4)
    println(readOnlyView)   // выведет "[1, 2, 3, 4]"
    //readOnlyView.clear()    // -> не скомпилируется
    val strings = hashSetOf("a", "b", "c", "c")
    assert(strings.size == 3)
    println(strings)

    /* Сокращение для "Если не null" */
    val files = File("Test").listFiles()
    println(files?.size)

    /* Сокращение для "Если не null, иначе" */
    val files1 = File("Test").listFiles()
    println(files1?.size ?: "empty")

    /* Вызов оператора при равенстве null */
    //val data = ...
    //val email = data["email"] ?: throw IllegalStateException("Email is missing!")

    /* Выполнение при неравенстве null */
    val data = "not null"
    data?.let {
        println("not null")
    }

    /* Выражение when */
    fun transform(color: String): Int {
        return when (color) {
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }
    println("Color = ${transform("Green")}")

    /* try/catch как выражение */
    fun test() {
        fun count(): Int = 0

        val result = try {
            count()
        } catch (e: ArithmeticException) {
            throw IllegalStateException(e)
        }

        // Обработка результата
    }

    /* if как выражение */
    fun foo(param: Int): String {
        val result = if (param == 1) {
            "one"
        } else if (param == 2) {
            "two"
        } else {
            "three"
        }
        return result
    }
    println(foo(1))

    /* Функция, состоящие из одного выражения */
    fun theAnswer() = 42

    // аналогична:
    fun theAnswer1(): Int {
        return 42
    }

    fun transform1(color: String): Int = when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }

    /* Вызов нескольких методов объекта ('with') */
    class Turtle {
        fun penDown() {}
        fun penUp() {}
        fun turn(degrees: Double) {}
        fun forward(pixels: Double) {}
    }

    val myTurtle = Turtle()
    with(myTurtle) {
        // вызывает методы объекта без указания объекта перед функцией
        //draw a 100 pix square
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }

    /* Интервалы */
    val i = 7
    if (i in 1..10) { // интервал [1,10]
        println("Да, $i принадлежит интервалу [1,10]")
    }
    for (i in 11..14) print("$i ") // 11 12 13 14
    println()
    for (i in 4..1) print(i) // nothing
    for (i in 14 downTo 11) print("$i ") // 14 13 12 11
    println()
    for (i in 2..10 step 2) print("$i ") // 2 4 6 8 10
    println()
    for (i in 1..10 step 2) print("$i ") // 1 3 5 7 9
    println()
    for (i in 10 downTo 1 step 2) print("$i ") // 10 8 6 4 2
    println()
    // создания интервала, который не включает последний элемент перебора, например [1, 10)
    for (i in 1 until 10) print("$i ") // 1 2 3 4 5 6 7 8 9
    println()

    /* Проверка объекта на принадлежность к определённому классу */
    val x: Int = 0;
    when (x) {
        is Int -> {
        }
        is Number -> {
        }
        else -> {
        }
    }

    /* Итерация по карте/списку пар */
    for ((key, value) in mapOf<Int, Int>(1 to 100, 2 to 200))
        println("$key -> $value")

    /* Функции-расширения */
    fun String.spaceToCamelCase() {}
    "Convert this to camelcase".spaceToCamelCase()

    /* Приведение и проверка типов */
    val obj: String = "abc"
    if (obj is String) print(obj.length)
    if (obj !is String) print("не тип String")

    /* Умные приведения */
    fun demo(x: Any) {
        if (x is String) print(x.length) // x автоматически преобразовывается в String
    }
    // или
    val xdd: Any = intArrayOf(1, 2, 3)
    when (xdd) {
        is Int -> print(xdd + 1)
        is String -> print(xdd.length + 1)
        is IntArray -> print(xdd.sum())
    }

    /* Оператор "небезопасного" приведения as */
//    val y222: Char = 'A'
//    val x11: String = y222 as String
//    val x12: String? = y222 as String?
//    println("x11=$x11 x12=$x12")
    println()

    /* Ключевое слово this с определителем */
    class All { // неявная метка @All
        /**
         * Внутренний класс
         */
        inner class B { // неявная метка @B
            fun Int.foo() { // неявная метка @foo
                val a = this@All // this из All
                val b = this@B // this из B

                val c = this // принимающий объект функции foo(), типа Int
                val c1 = this@foo // принимающий объект функции foo(), типа Int

                val funLit = lambda@ fun String.() {
                    val d = this // принимающий объект литерала funLit
                }


                val funLit2 = { s: String ->
                    // принимающий объект функции foo(), т.к. замыкание лямбды не имеет принимающего объекта
                    val d1 = this
                }
            }
        }
    }


    /* Равенство
    * - равенство ссылок (две ссылки указывают на один и тот же объект)
    * - равенство структур, - проверка через equals()
    */
    val qwe = 1
    val asd = 2
    val zxc = qwe
    // проверка равенства ссылок:
    println(qwe === asd) // false
    println(qwe !== asd) // true
    println(qwe === zxc) // true
    // проверка равенства структур:
    val poi = null
    val jlo: String = ""
    // - если poi не null, то equals(Any?)
    // - если poi null, то jlo сравнивается с (jlo === null), а именно с null
    println(poi?.equals(jlo) ?: (jlo === null))



    /* Перегрузка операторов */
    data class Point(val x: Int, val y: Int)

    operator fun Point.unaryMinus() = Point(-x, -y) // унарный минус
    operator fun Point.unaryPlus() = Point(+x, +y) // унарный плюс

    val point = Point(10, 20)
    println(-point)  // выведет "(-10, -20)"
    println(+point)  // выведет "(10, 20)"

    var xx: Int = 0;
    xx++ // xx.inc()
    xx-- // xx.dec()

    // Арифметические операции:
    //    a + b	    a.plus(b)
    //    a - b	    a.minus(b)
    //    a * b	    a.times(b)
    //    a / b	    a.div(b)
    //    a % b 	a.rem(b), a.mod(b) (устаревшее)
    //    a..b	    a.rangeTo(b)

    // Оператор in
    //    a in b	b.contains(a)
    //    a !in b	!b.contains(a)

    // Оператор доступа по индексу
    //    a[i]	a.get(i)
    //    a[i, j]	a.get(i, j)
    //    a[i_1, ..., i_n]	a.get(i_1, ..., i_n)
    //    a[i] = b	a.set(i, b)
    //    a[i, j] = b	a.set(i, j, b)
    //    a[i_1, ..., i_n] = b	a.set(i_1, ..., i_n, b)

    // Оператор вызова
    https://kotlinlang.ru/docs/reference/operator-overloading.html


}


// -============================================================-

/**
 * Нефиксированное число аргументов (Varargs)
 */
fun <T> asList(vararg inputList: T): List<T> {
    val result = ArrayList<T>()
    for (element in inputList) // inputList - это массив (Array)
        result.add(element)
    return result
}

/**
 * Как можно вызвать функцию с параметрами по умолчанию
 */
fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') {
    println()
    //return Unit
    //return
}

/**
 * Функции. Аргументы по умолчанию указываются после =
 */
fun readMe(b: Array<Byte>, offset: Int = 0, len: Int = b.size) {
    println(Arrays.toString(b))
    println(offset)
    println(len)
    //return Unit
    //return
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
    //return Unit
    //return
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

/**
 * Функция с одним выражением
 */
fun double(x: Int): Int = x * 2

// компилятор может сам определить тип возвращаемого значения
fun sum(a: Int, b: Int) = a + b

/**
 * Функция-расширения
 * Меняет значения местами в MutableList<T> по индексам
 */
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' относится к листу типа Т
    this[index1] = this[index2]
    this[index2] = tmp
    //return Unit
    //return
}

/**
 * Класс данных data class...
 *
 * Компятор автоматические создаёт:
 * - пара функций equals()/hashCode(),
 * - toString() в форме "User(name=Jhon, age=42)",
 * - функции componentN(), которые соответствуют свойствам, в зависимости от их порядка либо объявления,
 * - функция copy()
 *
 * Оформление:
 * - первичный конструктор должен иметь как минимум один параметр;
 * - все параметры первичного конструктора должны быть отмечены, как val или var;
 * - классы данных не могут быть абстрактными, open, sealed или inner;
 * - дата-классы не могут наследоваться от других классов (но могут реализовывать интерфейсы).
 */
data class User(val name: String, val age: Int)

/**
 * Метод класса возвращает сразу 2 результата
 */
data class Handler(var mul: Int = 1, var sum: Int = 0) {
    fun funReturnsTwoResults(i: Int): Handler {
        this.mul *= i;
        this.sum += i;
        return Handler(mul, sum)
    }
}
