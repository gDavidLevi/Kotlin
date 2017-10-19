package ru.davidlevi

open class Employer(person: Person, internal var company: String) : Person(person) {
    // final override fun - запретить возможность переопределения в производных классах
    final override fun setID(newId: Int) {
        println("Установили персоне id = ${newId}")
        super.setID(newId)
    }
}
