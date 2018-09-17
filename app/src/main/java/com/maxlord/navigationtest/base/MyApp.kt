package com.maxlord.navigationtest.base

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule

class MyApp : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidModule(this@MyApp))
        /* bindings */
    }
}