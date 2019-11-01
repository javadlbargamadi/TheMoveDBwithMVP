package com.example.themovedbwithmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themovedbwithmvp.MovieListClass.Result
import kotlinx.android.synthetic.main.tmdb_view.*

class TMDbView : AppCompatActivity(), TMDbMVPContract.TMDbView {

    private val searchResult = ArrayList<Result>()
    private lateinit var tmDbRecyclerAdapter: TMDbRecyclerAdapter
    private var resultList = ArrayList<Result>()
    private lateinit var tmDbPresenter: TMDbMVPContract.TMDbPresenter

    override fun setUpRecyclerView() {
        tmDbRecyclerAdapter = TMDbRecyclerAdapter(searchResult)
        recyclerView.adapter = tmDbRecyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
    }

    override fun getMovieName() {
        tmDbPresenter.getMovieList(edtUserMovie.text.toString())
    }

    override fun movieListReceived(movieList : ArrayList<Result>) {
        resultList = movieList
        searchResult.addAll(resultList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tmdb_view)

        tmDbPresenter = TMDbPresenter(this)

        setUpRecyclerView()
//        tmDbPresenter.searchButtonClicked()

        searchResult.addAll(resultList)

        btnSearch.setOnClickListener { tmDbPresenter.searchButtonClicked() }
    }
}
