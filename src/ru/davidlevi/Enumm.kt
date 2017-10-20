package ru.davidlevi

class Enumm {

    fun fsdfds(){
        val dir: Direction = Direction.NORTH
        val clr:Color = Color.BLUE
        val numClr: Int = Color.BLUE.rgb
    }
}

enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

enum class ProtocolState {
    /* анонимный класс внутри перечисления */
    WAITING {
        override fun signal() = TALKING
    }, // запятая

    /* анонимный класс внутри перечисления */
    TALKING {
        override fun signal() = WAITING
    }; // конец перечисления

    abstract fun signal(): ProtocolState
}

