package tech.danielwaiguru.rickandmorty

import android.app.Application
import timber.log.Timber

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}