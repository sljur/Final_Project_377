package com.jurado.finalproject.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jurado.finalproject.R
import com.jurado.finalproject.data.FavoriteCity

class FavoriteCityAdapter(
    private var cityList: List<FavoriteCity>,
    private val onCityClick: (FavoriteCity) -> Unit
) : RecyclerView.Adapter<FavoriteCityAdapter.CityViewHolder>() {


    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cityNameTextView: TextView = itemView.findViewById(R.id.cityNameTextView)

        fun bind(city: FavoriteCity, onCityClick: (FavoriteCity) -> Unit) {
            cityNameTextView.text = city.cityName
            itemView.setOnClickListener {
                onCityClick(city)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite_city, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cityList[position]
        holder.bind(city, onCityClick)
    }

    override fun getItemCount(): Int = cityList.size

    // Method to update data
    fun updateData(newCityList: List<FavoriteCity>) {
        cityList = newCityList
        notifyDataSetChanged() // Notify the adapter that the data has changed
    }
}


