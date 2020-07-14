package com.elgml.kotlinretrofitapi1.data

import com.elgml.kotlinretrofitapi1.pojo.PostModel
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class PostsClient {
    private val API_BASE_URL = "https://jsonplaceholder.typicode.com/"
    private var apiCalls: ApiCalls

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiCalls = retrofit.create()
    }

    companion object {
        val INSTANCE = PostsClient()
    }

    fun getAllPosts(): Call<List<PostModel>> {
        return apiCalls.getAllPosts()
    }
}