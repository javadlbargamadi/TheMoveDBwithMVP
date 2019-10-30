package com.example.themovedbwithmvp

import android.util.Log
import android.widget.Toast
import com.example.themovedbwithmvp.MovieListClass.MovieListClass
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
    fun fetchMovieList(movieName: String) {

        RetrofitProviderClass
            .provideRetrofit()
            .getMovieList(movieName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                tmDbPresenter.onMovieListReceived(it.results)
            }, {
                Log.d("MYTAG", it.message)
            }, {
                Log.d("MYTAG", "successful")
            })
    }
}
