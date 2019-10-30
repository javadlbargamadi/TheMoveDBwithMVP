package com.example.themovedbwithmvp

import com.example.themovedbwithmvp.MovieListClass.MovieListClass
import com.example.themovedbwithmvp.MovieListClass.Result
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDbMVPContract {

    interface TMDbView {
        fun setUpRecyclerView()
        fun getMovieName()
        //        fun searchButtonClicked()
        fun movieListReceived(movieList: List<Result>)
    }

    interface TMDbPresenter {
        fun getMovieList(movieName: String)
        fun onMovieListReceived(movieList: List<Result>)
        fun searchButtonClicked()
    }
}