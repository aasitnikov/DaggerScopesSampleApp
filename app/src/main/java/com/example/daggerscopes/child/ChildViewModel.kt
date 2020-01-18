package com.example.daggerscopes.child

import androidx.lifecycle.ViewModel
import com.example.daggerscopes.data.DataSource
import javax.inject.Inject

class ChildViewModel @Inject constructor(
    private val dataSource: DataSource
) : ViewModel() {

    fun double() {
        dataSource.double()
    }

    fun half() {
        dataSource.half()
    }
}