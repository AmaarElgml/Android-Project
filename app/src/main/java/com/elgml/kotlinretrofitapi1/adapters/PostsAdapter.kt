package com.elgml.kotlinretrofitapi1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elgml.kotlinretrofitapi1.R
import com.elgml.kotlinretrofitapi1.pojo.PostModel
import kotlinx.android.synthetic.main.post_item.view.*

class PostsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var postsList: List<PostModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostViewHolder -> {
                holder.bindViews(postsList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return postsList.count()
    }

    fun setList(postsList: List<PostModel>) {
        this.postsList = postsList
        notifyDataSetChanged()
    }

    class PostViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val postIdView: TextView = itemView.postId
        private val userIdView: TextView = itemView.userId
        private val titleView: TextView = itemView.title
        private val bodyView: TextView = itemView.body

        fun bindViews(postModel: PostModel) {
            postIdView.text = "Post number ${postModel.id}"
            userIdView.text = "User ${postModel.userId}"
            titleView.text = postModel.title
            bodyView.text = postModel.body
        }
    }

}