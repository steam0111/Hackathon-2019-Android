package com.itrocket.hackaton.di

import com.itrocket.hackaton.BuildConfig
import com.itrocket.hackaton.model.data.server.ItRocketApi
import com.itrocket.hackaton.model.data.storage.Prefs
import com.itrocket.hackaton.model.repository.ItRocketRepository
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single{ provideDefaultOkhttpClient() }
    single{ provideRetrofit(get()) }
    single{ provideItRocketService(get()) }
    single{ ItRocketRepository(get(), get()) }
    single { Prefs(androidContext()) }
}

fun provideDefaultOkhttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .build()
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(provideDefaultOkhttpClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

fun provideItRocketService(retrofit: Retrofit): ItRocketApi = retrofit.create(ItRocketApi::class.java)
