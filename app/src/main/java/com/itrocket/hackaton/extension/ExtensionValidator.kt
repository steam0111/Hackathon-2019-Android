package com.itrocket.hackaton.extension

fun String.isNotValidEmail() : Boolean {
    return this.isEmpty()
}