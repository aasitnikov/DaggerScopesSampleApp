package com.example.daggerscopes.app

import android.app.Application
import com.example.daggerscopes.di.Di
import com.example.daggerscopes.di.HasAppComponent

class App : Application(), HasAppComponent {

    override val component: AppComponent get() = Di.appComponent

    override fun onCreate() {
        super.onCreate()
        Di.appComponent = DaggerAppComponent.create()
    }
}