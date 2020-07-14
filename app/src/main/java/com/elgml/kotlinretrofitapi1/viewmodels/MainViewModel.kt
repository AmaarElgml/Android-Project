package com.elgml.kotlinretrofitapi1.viewmodels

import android.content.Context
import android.widget.Toast
import retrofit2.Callback
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elgml.kotlinretrofitapi1.data.PostsClient
import com.elgml.kotlinretrofitapi1.pojo.PostModel
import retrofit2.Call
import retrofit2.Response

class MainViewModel : ViewModel() {
    var postsMutableLiveData: MutableLiveData<List<PostModel>> = MutableLiveData()

    fun getPosts(context: Context) {
        PostsClient.INSTANCE.getAllPosts()
            .enqueue(object : Callback<List<PostModel>> {
                override fun onResponse(
                    call: Call<List<PostModel>>,
                    response: Response<List<PostModel>>
                ) {
                    postsMutableLiveData.value = response.body()
                }

                override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                }
            })
    }

}