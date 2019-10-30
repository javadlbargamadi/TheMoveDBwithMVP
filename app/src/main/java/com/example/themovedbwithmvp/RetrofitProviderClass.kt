package com.example.themovedbwithmvp

import com.example.themovedbwithmvp.MovieListClass.MovieListClass
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProviderClass(private val tmDbModel: TMDbModel) {

    companion object {
        fun provideRetrofit(): RetrofitInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(RetrofitInterface::class.java)
        }
    }
}