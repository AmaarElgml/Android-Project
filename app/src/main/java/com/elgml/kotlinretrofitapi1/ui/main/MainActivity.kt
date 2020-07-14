package com.elgml.kotlinretrofitapi1.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.elgml.kotlinretrofitapi1.R
import com.elgml.kotlinretrofitapi1.adapters.PostsAdapter
import com.elgml.kotlinretrofitapi1.pojo.PostModel
import com.elgml.kotlinretrofitapi1.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var postsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getPosts(this)
        viewModel.postsMutableLiveData.observe(this,
            Observer<List<PostModel>> { postsList ->
                if (postsList.isNotEmpty())
                    postsAdapter.setList(postsList)
            })
    }

    private fun initRecyclerView() {
        postsRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            postsAdapter = PostsAdapter()
            adapter = postsAdapter
        }
    }


}
