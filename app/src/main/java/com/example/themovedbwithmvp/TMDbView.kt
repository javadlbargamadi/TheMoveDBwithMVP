package com.example.themovedbwithmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themovedbwithmvp.MovieListClass.Result
import kotlinx.android.synthetic.main.tmdb_view.*

class TMDbView : AppCompatActivity(), TMDbMVPContract.TMDbView {

    private lateinit var tmDbRecyclerAdapter: TMDbRecyclerAdapter
    private var resultList = ArrayList<Result>()
    private lateinit var tmDbPresenter: TMDbMVPContract.TMDbPresenter

    override fun setUpRecyclerView() {
        tmDbRecyclerAdapter = TMDbRecyclerAdapter(resultList)
        recyclerView.adapter = tmDbRecyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
    }

    override fun getMovieName() {
        tmDbPresenter.getMovieList(edtUserMovie.text.toString())
    }

    override fun movieListReceived(movieList: List<Result>) {
        resultList.add(movieList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tmdb_view)

        tmDbPresenter = TMDbPresenter(this)

        setUpRecyclerView()

        btnSearch.setOnClickListener { tmDbPresenter.searchButtonClicked() }
    }
}

