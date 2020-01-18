package com.example.daggerscopes.parent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.daggerscopes.data.DataSource
import javax.inject.Inject

class ParentViewModel @Inject constructor(
    private val dataSource: DataSource
) : ViewModel() {

    val number = dataSource.observe().asLiveData()

    fun inc() {
        dataSource.inc()
    }

    fun dec() {
        dataSource.dec()
    }
}