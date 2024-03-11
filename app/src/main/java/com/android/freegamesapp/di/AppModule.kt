package com.android.freegamesapp.di

import com.android.freegamesapp.core.utils.Constants
import com.android.freegamesapp.data.remote.FreeGamesApi
import com.android.freegamesapp.data.repository.FreeGamesRepositoryImpl
import com.android.freegamesapp.domain.repository.FreeGamesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providesRetrofitInstance(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()


    @Provides
    @Singleton
    fun providesFreeGamesApi(retrofit: Retrofit): FreeGamesApi =
        retrofit.create(FreeGamesApi::class.java)

    @Provides
    @Singleton
    fun providesFreeGamesRepository(freeGamesApi: FreeGamesApi): FreeGamesRepository {
        return FreeGamesRepositoryImpl(freeGamesApi)
    }

}
