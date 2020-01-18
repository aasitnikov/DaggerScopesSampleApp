package com.example.daggerscopes.di

import androidx.fragment.app.Fragment
import com.example.daggerscopes.app.AppComponent
import com.example.daggerscopes.di.common.ComponentFinder
import com.example.daggerscopes.parent.ParentComponent

interface HasAppComponent {
    val component: AppComponent
}

interface HasParentComponent {
    val component: ParentComponent
}

object AppComponentFinder {
    fun find(fragment: Fragment): AppComponent = ComponentFinder.find<HasAppComponent>(fragment).component
}

object ParentComponentFinder {
    fun find(fragment: Fragment): ParentComponent {
        return ComponentFinder.find<HasParentComponent>(fragment).component
    }
}
