package com.example.themovedbwithmvp

import com.example.themovedbwithmvp.MovieListClass.Result

class TMDbPresenter(private val tmDbView: TMDbMVPContract.TMDbView) :
    TMDbMVPContract.TMDbPresenter {

    private val tmDbModel = TMDbModel(this)

    override fun getMovieList(movieName: String) {
        tmDbModel.fetchMovieList(movieName)
    }

    override fun onMovieListReceived(movieList: List<Result>) {
        tmDbView.movieListReceived(movieList)
    }

    override fun searchButtonClicked() {
        tmDbView.getMovieName()
    }
}