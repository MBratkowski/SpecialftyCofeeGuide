package io.bratexsoft.specialtycofeecode.di.module

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.bratexsoft.specialtycofeecode.BuildConfig
import io.bratexsoft.specialtycofeecode.repository.network.APIConfig
import io.bratexsoft.specialtycofeecode.repository.network.RequestDefinition
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideCache(context: Context): Cache {
        return Cache(File(context.cacheDir, "CoffeAppCache"), 10)
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        return interceptor
    }

    @Provides
    @Singleton
    fun buildOKhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient.Builder {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        builder.connectTimeout(10, TimeUnit.SECONDS)
        builder.writeTimeout(10, TimeUnit.SECONDS)
        builder.readTimeout(30, TimeUnit.SECONDS)
        builder.addNetworkInterceptor(StethoInterceptor())
        builder.addInterceptor(httpLoggingInterceptor)
        builder.cache(cache)

        return builder
    }

    @Singleton
    @Provides
    fun provideOkHttp(builder: OkHttpClient.Builder): OkHttpClient = builder.build()

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(APIConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Singleton
    @Provides
    fun provideNetworkService(retrofit: Retrofit): RequestDefinition = retrofit.create(RequestDefinition::class.java)
}