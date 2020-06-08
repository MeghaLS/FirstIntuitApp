package com.example.firstintuitapp

fun String.isIntuitEmpty(): Boolean {
    return this.length === 0
}
fun test() {
    val name="Megha"
    name.isIntuitEmpty()
}

