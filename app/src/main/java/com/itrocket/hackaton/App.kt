package com.itrocket.hackaton

import android.app.Application
import com.itrocket.hackaton.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(appModule))
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }


    companion object {
        const val errorMsg = "В приложении произошла ошибка"

        //valid fields
        const val chooseUnivMsg = "Выбирите университет"
        const val nameNotValidMsg = "Имя не может быть пустым"
        const val secondNotValidMsg = "Фамилия не может быть пустым"
        const val lastNameNotValidMsg = "Отчество не может быть пустым"
        const val emailNotValidMsg = "Почта не может быть пустой"
        const val passwordNotValidMsg = "Пароль не может быть пустым"
    }
}