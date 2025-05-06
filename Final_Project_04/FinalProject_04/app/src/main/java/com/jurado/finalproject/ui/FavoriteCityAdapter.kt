package com.jurado.finalproject.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jurado.finalproject.R
import com.jurado.finalproject.data.FavoriteCity

// Adapter for displaying favorite cities in a RecyclerView
class FavoriteCityAdapter(
    private val onRemoveClick: (FavoriteCity) -> Unit,
    private val onItemClick: (FavoriteCity) -> Unit
) : ListAdapter<FavoriteCity, FavoriteCityAdapter.FavoriteCityViewHolder>(FavoriteCityDiffCallback()) {

    // ViewHolder for each item in the RecyclerView
    class FavoriteCityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cityNameTextView: TextView = view.findViewById(R.id.cityNameTextView)
        val removeCityButton: Button = view.findViewById(R.id.removeCityButton)
    }

    // Creates new ViewHolders for the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteCityViewHolder {
        // Inflates the layout for a single favorite city item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite_city, parent, false)
        return FavoriteCityViewHolder(view)
    }

    // Binds data to the ViewHolder at the specified position
    override fun onBindViewHolder(holder: FavoriteCityViewHolder, position: Int) {
        val favoriteCity = getItem(position)
        holder.cityNameTextView.text = favoriteCity.cityName

        holder.removeCityButton.setOnClickListener {
            onRemoveClick(favoriteCity)
        }

        holder.itemView.setOnClickListener {
            onItemClick(favoriteCity)
        }
    }
}

// Check for duplicates in the list
class FavoriteCityDiffCallback : DiffUtil.ItemCallback<FavoriteCity>() {
    override fun areItemsTheSame(oldItem: FavoriteCity, newItem: FavoriteCity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FavoriteCity, newItem: FavoriteCity): Boolean {
        return oldItem == newItem
    }
}