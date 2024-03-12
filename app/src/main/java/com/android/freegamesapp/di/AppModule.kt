package com.android.freegamesapp.di

import com.android.freegamesapp.core.utils.Constants
import com.android.freegamesapp.data.remote.FreeGamesApi
import com.android.freegamesapp.data.repository.FreeGamesRepositoryImpl
import com.android.freegamesapp.domain.repository.FreeGamesRepository
import com.android.freegamesapp.domain.usecase.FreeGamesUseCase
import com.android.freegamesapp.presentation.viewmodel.FreeGamesViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(FreeGamesApi::class.java)
    }

    single<FreeGamesRepository> {
        FreeGamesRepositoryImpl(get())
    }

    factory {
        FreeGamesUseCase(get())
    }

    viewModelOf(::FreeGamesViewModel)



}

/*object AppModule {

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

}*/
