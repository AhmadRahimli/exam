package com.rahimliahmad.exam_23_05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahimliahmad.exam_23_05.adapter.Adapter
import com.rahimliahmad.exam_23_05.adapter.DetAdapter
import com.rahimliahmad.exam_23_05.adapter.GenAdapter
import com.rahimliahmad.exam_23_05.databinding.ActivityMainBinding
import com.rahimliahmad.exam_23_05.model.Genres
import com.rahimliahmad.exam_23_05.model.Results
import com.rahimliahmad.exam_23_05.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycle.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        getPopMovie()
        binding.button4.setOnClickListener {
            getDetail()
            getGenre()
        }
    }
    fun getPopMovie(){
        val call: Call<Results>? = RetrofitClient.getRetrofitInstance()?.getApi()?.getPopMovie()
        call?.enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<Results>?, response: Response<Results>?) {
                val newsList: Results = response?.body() as Results
                binding.recycle.adapter = Adapter(newsList.results)
            }
            override fun onFailure(call: Call<Results>?, t: Throwable?) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
    fun getDetail(){
        val call: Call<Results>? = RetrofitClient.getRetrofitInstance()?.getApi()?.getPopMovie()
        call?.enqueue(object : Callback<Results> {
            override fun onResponse(call: Call<Results>?, response: Response<Results>?) {
                val newsList3: Results = response?.body() as Results
                binding.recycle.adapter = DetAdapter(newsList3.)
            }
            override fun onFailure(call: Call<Results>?, t: Throwable?) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
    fun getGenre(){
        val call: Call<Genres>? = RetrofitClient.getRetrofitInstance()?.getApi()?.getGenre()
        call?.enqueue(object : Callback<Genres> {
            override fun onResponse(call: Call<Genres>?, response: Response<Genres>?) {
                val newsList2: Genres = response?.body() as Genres
                binding.recycle.adapter = GenAdapter(newsList2.genres)
            }
            override fun onFailure(call: Call<Genres>?, t: Throwable?) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }
        })
    }
}