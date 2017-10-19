package ru.davidlevi

class OtherNewClass(person: Person, company: String) : Employer(person, company) {
    /* Уже здесь невозможно переопределить (override) метод setID из Employer потому, что он с final override */
}