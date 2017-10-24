package ru.davidlevi

class A { // неявная метка @A
    inner class B { // неявная метка @B
        fun Int.foo() { // неявная метка @foo
            val a = this@A // this из A
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


https://kotlinlang.ru/docs/reference/ranges.html