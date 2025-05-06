package com.jurado.finalproject.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jurado.finalproject.R
import com.jurado.finalproject.data.CityData

class CityAdapter(
    private var cityList: List<CityData>,
    private val onItemClick: (CityData) -> Unit,
    private val onFavoriteClick: (CityData) -> Unit
) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    class CityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cityName: TextView = view.findViewById(R.id.cityName)
        val countryName: TextView = view.findViewById(R.id.countryName)
        val favoriteButton: Button = view.findViewById(R.id.favoriteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cityList[position]
        holder.cityName.text = city.name
        holder.countryName.text = city.country

        holder.itemView.setOnClickListener { onItemClick(city) }
        holder.favoriteButton.setOnClickListener { onFavoriteClick(city) }
    }

    override fun getItemCount(): Int = cityList.size

    fun updateData(newCityList: List<CityData>) {
        cityList = newCityList
        notifyDataSetChanged()
    }
}
