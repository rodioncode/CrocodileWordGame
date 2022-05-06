package com.rodiondev.crocodilewordgame.common

interface EventHandler<E> {
    fun obtainEvent(event: E)
}