package com.example.daggerscopes.app

import com.example.daggerscopes.parent.ParentComponent
import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface AppComponent {

    fun parentComponent(): ParentComponent

}



