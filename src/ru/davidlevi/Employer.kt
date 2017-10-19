package ru.davidlevi

class Employer(person: Person, private var company: String) : Person(person) {

    fun getCompany(): String {
        return this.company
    }
}
