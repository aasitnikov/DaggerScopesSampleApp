package com.example.daggerscopes.child

import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Scope

@Subcomponent
@ChildScope
interface ChildComponent {

    val viewModel: ChildViewModel

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance constant: ChildConstant
        ): ChildComponent
    }
}

@Scope
annotation class ChildScope