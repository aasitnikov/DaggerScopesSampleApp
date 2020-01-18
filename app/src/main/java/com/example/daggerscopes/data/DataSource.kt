package com.example.daggerscopes.data

import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSource @Inject constructor() {

    private val channel = ConflatedBroadcastChannel(0)

    fun observe(): Flow<Int> {
        return channel.asFlow()
    }

    fun inc() {
        channel.offer(channel.value + 1)
    }

    fun dec() {
        channel.offer(channel.value - 1)
    }

    fun double() {
        channel.offer(channel.value * 2)
    }

    fun half() {
        channel.offer(channel.value / 2)
    }
}