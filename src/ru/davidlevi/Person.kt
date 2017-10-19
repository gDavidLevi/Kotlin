package ru.davidlevi

open class Person {
    /* неизменяемые приватные поля, final */
    private val id: Int = 0

    /* изменяемые приватные поля */
    private var name: String = ""
    private var age: Int = 0
    private var email: String = ""
    private var college: String? = null
    private var salary: Float = 0.0f

    /* доступ возможен через getter и setter */
    var publicAccess: String = ""

    constructor(name: String, age: Int, email: String, college: String?, salary: Float) {
        this.name = name
        this.age = age
        this.email = email
        this.college = college
        this.salary = salary
    }

    constructor(other: Person) {
        this.name = other.name
        this.age = other.age
        this.email = other.email
        this.college = other.college
        this.salary = other.salary
    }

    fun getSalary(): Float {
        return this.salary
    }

    fun setSalary(newSalary: Float) {
        this.salary = newSalary
    }

    override fun toString(): String {
        return "\nName: ${this.name}\nAge: ${this.age}\nE-mail: ${this.email}\nCollege: ${this.college}"
    }
}