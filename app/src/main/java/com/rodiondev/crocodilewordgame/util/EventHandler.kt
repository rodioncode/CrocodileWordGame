package com.rodiondev.crocodilewordgame.util

interface EventHandler<E> {
    fun obtainEvent(event: E)
}