package ru.davidlevi

/**
 * Kotlin не имеет модификатора static, а это значит, что мы не можем создавать статические переменные и методы.
 * Ключевое слово companion object используется для доступа к членам конкретного класса.
 */
class Singleton1 {
    companion object Factory {
        var info: String? = null

        fun getMoreInfo(): String {
            return "This is factory fun"
        }
    }
}
