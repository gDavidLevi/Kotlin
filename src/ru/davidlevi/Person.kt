package ru.davidlevi

// open - не final => может наследоваться
// без open класс является final
open class Person : Adam {
    /* неизменяемые приватные поля, final */
    // protected - то же самое, что и private + видимость в субклассах;
    protected val constanta: Int = 0

    /* изменяемые приватные поля */
    // private - private означает видимость только внутри этого класса (включая его членов)
    private var name: String = ""
    private var age: Int = 0
    private var email: String = ""
    private var college: String? = null
    private var salary: Float = 0.0f

    private var id: Int = 0;

    /* доступ возможен через getter и setter */
    // internal - любой клиент внутри модуля, который видит объявленный класс, видит и его internal члены
    internal var publicAccess: String = ""
        get() = field
        set(value) {
            field = value
        }

    //public - любой клиент, который видит объявленный класс, видит его public члены
    public constructor(name: String, age: Int, email: String, college: String?, salary: Float) {
        this.name = name
        this.age = age
        this.email = email
        this.college = college
        this.salary = salary
    }

    /* Перегруженный конструктор */
    constructor(other: Person) {
        this.name = other.name
        this.age = other.age
        this.email = other.email
        this.college = other.college
        this.salary = other.salary
    }

    /* метод возвращающий */
    fun getSalary(): Float {
        return this.salary
    }

    /* метод устанавливающий */
    fun setSalary(newSalary: Float) {
        this.salary = newSalary
    }

    // override - переопределение
    override fun toString(): String {
        return "\nName: ${this.name}\nAge: ${this.age}\nE-mail: ${this.email}\nCollege: ${this.college}"
    }

    /* open fun разрешает наследнику этот метод override (переопределить) */
    open fun setID(newId:Int) {
        this.id = newId
    }

    // имплементировали из абстрактного класса Adam
    override fun a() {
        println("переопределили a() ")
    }
}