package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_items.view.*

class MyAdapter(val context: Context, val userList: List<MyDataItem>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                var postTitle: TextView
                var postDetail: TextView

                init {
                    postTitle = itemView.post_title
                    postDetail = itemView.post_detail
                }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                var itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
                return  ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.postTitle.text = userList[position].title.toString()
                holder.postDetail.text = userList[position].body.toString()
        }

        override fun getItemCount(): Int {
                return userList.size
        }


}