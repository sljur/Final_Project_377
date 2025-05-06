package com.jurado.finalproject.data
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FavoriteCityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(city: FavoriteCity)

    @Query("SELECT * FROM favorite_cities")
    fun getAllFavorites(): LiveData<List<FavoriteCity>>

    @Delete
    suspend fun delete(city: FavoriteCity)
}

