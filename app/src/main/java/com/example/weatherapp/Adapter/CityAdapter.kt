package com.example.weatherapp.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.Activity.MainActivity
import com.example.weatherapp.databinding.CityViewholderBinding
import com.example.weatherapp.databinding.ForecastViewholderBinding
import com.example.weatherapp.model.CityResponseApi
import com.example.weatherapp.model.ForecastResponseApi
import java.text.SimpleDateFormat
import java.util.Calendar

class CityAdapter: RecyclerView.Adapter<CityAdapter.ViewHolder>() {
    private lateinit var binding:CityViewholderBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        binding= CityViewholderBinding.inflate(inflater,parent,false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = CityViewholderBinding.bind(holder.itemView)
        binding.textView2.text=differ.currentList[position].name
        binding.root.setOnClickListener {
            val intent=Intent(binding.root.context,MainActivity::class.java)
            intent.putExtra("lat",differ.currentList[position].lat)
            intent.putExtra("lng",differ.currentList[position].lon)
            intent.putExtra("name",differ.currentList[position].name)
            binding.root.context.startActivity(intent)
        }

    }
    inner class ViewHolder:RecyclerView.ViewHolder(binding.root)

    override fun getItemCount()= differ.currentList.size

    private val differCallBack=object :DiffUtil.ItemCallback<CityResponseApi.CityResponseApiItem>(){
        override fun areItemsTheSame(
            oldItem: CityResponseApi.CityResponseApiItem,
            newItem: CityResponseApi.CityResponseApiItem,
        ): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(
            oldItem: CityResponseApi.CityResponseApiItem,
            newItem: CityResponseApi.CityResponseApiItem,
        ): Boolean {
            return oldItem==newItem
        }

    }
    val differ=AsyncListDiffer(this,differCallBack)

}