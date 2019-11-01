package com.example.themovedbwithmvp

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.themovedbwithmvp.MovieListClass.MovieListClass
import com.example.themovedbwithmvp.MovieListClass.Result
import io.reactivex.MaybeObserver
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class TMDbModel(private val tmDbPresenter: TMDbMVPContract.TMDbPresenter) {

    private val context: Context? = null

    fun fetchMovieList(movieName: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        retrofit.create(RetrofitInterface::class.java)
            .getMovieList(movieName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                tmDbPresenter.onMovieListReceived(it.results as ArrayList<Result>)
            }, {
                Log.d("MYTAG", it.message)
            })
    }
}
//
//
//
//        fun fetchMovieList(movieName: String) {
//
//            RetrofitProviderClass
//                .provideRetrofit()
//                .getMovieList(movieName)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    tmDbPresenter.onMovieListReceived(it.results)
//                }, {
//                    Log.d("MYTAG", it.message)
//                }, {
//                    Log.d("MYTAG", "successful")
//                })
//        }
//    }
