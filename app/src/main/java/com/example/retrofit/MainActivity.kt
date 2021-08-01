package com.example.retrofit

import ApiInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview_users.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerview_users.layoutManager = linearLayoutManager

        getMyData();

    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<MyDataItem>> {
            override fun onResponse(call: Call<List<MyDataItem>>, response: Response<List<MyDataItem>>) {
                val responseBody = response.body() !!

                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerview_users.adapter = myAdapter


            }

            override fun onFailure(call: Call<List<MyDataItem>>, t: Throwable) {
                d("MainActivity", "onFailure: "+t.message)
            }
        })

    }
}