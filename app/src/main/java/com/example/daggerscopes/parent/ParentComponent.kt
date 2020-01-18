package com.example.daggerscopes.parent

import com.example.daggerscopes.child.ChildComponent
import dagger.Subcomponent
import javax.inject.Scope

@Subcomponent
@ParentScope
interface ParentComponent {

    fun childComponent(): ChildComponent.Factory
    val viewModel: ParentViewModel

}

@Scope
annotation class ParentScope