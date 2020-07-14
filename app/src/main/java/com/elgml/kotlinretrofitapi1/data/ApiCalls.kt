package com.elgml.kotlinretrofitapi1.data

import com.elgml.kotlinretrofitapi1.pojo.PostModel
import retrofit2.Call
import retrofit2.http.*

interface ApiCalls {

    // Get all posts
    @GET("posts")
    fun getAllPosts():
            Call<List<PostModel>>

}